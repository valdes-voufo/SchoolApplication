package com.ydova.schoolapp.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SchoolFeesController implements Initializable {
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {}

  /*
      private Student selectedStudent;
      private final ObservableList<Student> studentsList = new Linked;

      HashMap<Student, String> studentStringHashMap;
      private AutoCompletionBinding<String> autoProposition;

      @FXML
      private TableColumn<Student, String> telColumn;
      @FXML
      private TableColumn<Student, String> classColumn;
      @FXML
      private ChoiceBox<String> classrooms;
      @FXML
      private TableColumn<Student, String> idColumn;
      @FXML
      private TableColumn<Student, String> nameColumn;
      @FXML
      private TableColumn<Student, String> schoolFeesColumn;
      @FXML
      private TextField searchTextfield;
      @FXML
      private TableView<Student> tableView;



      public SchoolFeesController() throws SQLException {
      }

      public void feelStudentHashmap() {
          for (Student a : studentsList) {
              studentStringHashMap.put(a, a.getFullName() + " (" + a.getStudentID() + " )");
          }
      }

      public void updateStudentList(Student student) {
          for (Student a : studentsList) {
              if (a.getStudentID() == student.getStudentID()) {
                  return;
              }
          }

          studentsList.add(student);
      }

      @Override
      public void initialize(URL location, ResourceBundle resources) {


          schoolFeesColumn.setCellValueFactory(cellData -> cellData.getValue().feeProperty());
          classColumn.setCellValueFactory(cellData -> cellData.getValue().classRooIDProperty());
          idColumn.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty());
          nameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());


          telColumn.setCellValueFactory(cellData -> cellData.getValue().parentNumberProperty());


          FilteredList<Student> filteredData = new FilteredList<>(studentsList, b -> true);

          searchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
              filteredData.setPredicate(student -> {
                  if (newValue == null || newValue.isEmpty()) {
                      return true;
                  }
                  String lowerCaseFilter = newValue.toLowerCase();

                  if (student.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                      return true;
                  } else if (student.getStudentID().toLowerCase().contains(lowerCaseFilter)) {
                      return true;

                  } else return student.getParentNumber().toLowerCase().contains(lowerCaseFilter);

              });
          });

          SortedList<Student> sortedData = new SortedList<>(filteredData);
          sortedData.comparatorProperty().bind(tableView.comparatorProperty());
          tableView.setItems(sortedData);
      }



      /*
  tableView.setOnMouseClicked(event -> {
          if (event.getClickCount() == 2) {
              // Récupérer la ligne sélectionnée
              Student selectedStudent = tableView.getSelectionModel().getSelectedItem();

              // Vérifier si une ligne est sélectionnée
              if (selectedStudent != null) {
                  // Ouvrir la nouvelle page en utilisant la classe FXMLLoader
                  try {
                      FXMLLoader loader = new FXMLLoader(getClass().getResource("nouvellePage.fxml"));
                      Parent root = loader.load();
                      NouvellePageController nouvellePageController = loader.getController();
                      nouvellePageController.setStudent(selectedStudent);

                      // Créer une nouvelle fenêtre pour afficher la nouvelle page
                      Stage stage = new Stage();
                      stage.setScene(new Scene(root));
                      stage.show();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
      });

  */

}
