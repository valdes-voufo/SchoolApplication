package com.ydova.schoolapp.controller;

import com.ydova.schoolapp.entity.ClassRoom;
import com.ydova.schoolapp.entity.Level;
import com.ydova.schoolapp.entity.Section;
import com.ydova.schoolapp.entity.Student;
import com.ydova.schoolapp.observer.ClassroomDataObserver;
import com.ydova.schoolapp.observer.LevelDataObserver;
import com.ydova.schoolapp.observer.SectionDataObserver;
import com.ydova.schoolapp.observer.StudentDataObserver;
import com.ydova.schoolapp.service.ClassroomService;
import com.ydova.schoolapp.service.StudentService;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentController
    implements Initializable,
        Controller,
        ClassroomDataObserver,
        StudentDataObserver,
        LevelDataObserver,
        SectionDataObserver {
  public TextField searchTexField;
  public ComboBox<Section> section;
  public ComboBox<Level> level;
  public ComboBox<ClassRoom> classroom1;
  public TableView<Student> studentTable;
  public TableColumn<Student, String> studentId;
  public TableColumn<Student, String> lastname;
  public TableColumn<Student, String> firstname;
  public TableColumn<Student, Long> number;
  public TableColumn<Student, Date> birthday;
  public TableColumn<Student, Double> fee;
  public TableColumn<Student, ClassRoom> classroom;

  String file = "classpath:/schoolapp/layout/main/main-right/student/student.fxml";

  private ClassroomService classroomService;
  private StudentService studentService;
  private ObservableList<Section> sectionList = FXCollections.observableArrayList();
  private ObservableList<Level> levelList = FXCollections.observableArrayList();
  private ObservableList<ClassRoom> classroomList = FXCollections.observableArrayList();
  private ObservableList<Student> studentList = FXCollections.observableArrayList();

  private StackPane pane;

  public StudentController() {}

  @FXML
  void pictureImport(ActionEvent event) {}

  @FXML
  void receptPrint(ActionEvent event) {}

  @FXML
  void scolarityPaiement(ActionEvent event) {}

  @FXML
  void studentInfosPrint(ActionEvent event) {}

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // observe to update on change
   // classroomService.addObserver((ClassroomDataObserver) this);
   // classroomService.addObserver((SectionDataObserver) this);
   // classroomService.addObserver((LevelDataObserver) this);
    // studentService.addObserver() fixme add student onserver

    // initialize list
   // classroomList = FXCollections.observableArrayList(classroomService.getAllClassroom());
   // sectionList = FXCollections.observableArrayList(classroomService.getAllSection());
   // levelList = FXCollections.observableArrayList(classroomService.getAllLevel());
    studentList = FXCollections.observableArrayList(studentService.getAllStudents());

    // add items
    section.setItems(sectionList);
    level.setItems(levelList);
    classroom1.setItems(classroomList);
    studentTable.setItems(studentList);

    // init columns
    firstname.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstname()));
    lastname.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastname()));
  }

  @Override
  public Parent getPane() {
    return pane;
  }

  @Override
  public Parent buildPaneRecursive() {
  //  pane = Loader.load(resource, ctx);
    return pane;
  }

  @Override
  public void onClassroomUpdated(ClassRoom classRoom) {
   // classroomList = FXCollections.observableArrayList(classroomService.getAllClassroom());
  }

  @Override
  public void onStudentUpdated(Student student) {
    // FIXME: 24.07.2023

  }

  @Override
  public void onLevelUpdated(Level level) {
   // levelList = FXCollections.observableArrayList(classroomService.getAllLevel());
  }

  @Override
  public void onSectionUpdated(Section section) {
   // sectionList = FXCollections.observableArrayList(classroomService.getAllSection());
  }
}
