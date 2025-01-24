package com.ydova.schoolapp.controller;

import com.ydova.schoolapp.entity.Classroom;
import com.ydova.schoolapp.entity.Level;
import com.ydova.schoolapp.entity.Section;
import com.ydova.schoolapp.entity.Student;
import com.ydova.schoolapp.service.StudentService;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class MainStudentController implements Controller {
  public TableColumn<Student, String> classroom;
  public TableColumn<Student, String> number;
  public ComboBox<Section> section;
  public ComboBox<Level> level;
  public ComboBox<Classroom> classroom1;
  StudentService service;
  private StackPane pane;

  @FXML private TextField searchTexField;
  @FXML private TableView<Student> studentTable;
  @FXML private TableColumn<Student, String> studentId;
  @FXML private TableColumn<Student, String> lastname;
  @FXML private TableColumn<Student, String> firstname;
  @FXML private TableColumn<Student, String> status;
  @FXML private TableColumn<Student, String> birthday;
  @FXML private TableColumn<Student, String> fee;

  @FXML
  public void initialize() {
    studentId.setCellValueFactory(
        cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStudentId())));

    lastname.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getLastname()));
    firstname.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getFirstname()));

    fee.setCellValueFactory(
        cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStudentFee())));
    studentTable.setItems(FXCollections.observableArrayList(this.service.readAll()));

    // Listen for database changes and update the TableView

    ObservableList<Student> studentsList =FXCollections.observableList( service.readAll());
    FilteredList<Student> filteredData = new FilteredList<>(studentsList, b -> true);

    searchTexField
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              filteredData.setPredicate(
                  student -> {
                    if (newValue == null || newValue.isEmpty()) {
                      return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (student.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                      return true;
                    } else if (String.valueOf(student.getStudentId())
                        .toLowerCase()
                        .contains(lowerCaseFilter)) {
                      return true;

                    } else return student.getLastname().toLowerCase().contains(lowerCaseFilter);
                  });
            });

    SortedList<Student> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(studentTable.comparatorProperty());
    studentTable.setItems(sortedData);
  }

  private void handleUserChange(Student user) {
    // Handle the user change event
    Platform.runLater(
        () -> {
          // Update the TableView with the new or updated user
          ObservableList<Student> userList = studentTable.getItems();
          int index = userList.indexOf(user);
          if (index >= 0) {
            userList.set(index, user);
          } else {
            userList.add(user);
          }
        });
  }


}
