package com.ydova.schoolapp.client.views;

import com.ydova.schoolapp.server.entity.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class StudentListPage implements Initializable, Controller {

  private Student selectedStudent;

  HashMap<Student, String> studentStringHashMap;

  @FXML private TableColumn<Student, String> telColumn;
  @FXML private TableColumn<Student, String> classColumn;
  @FXML private ChoiceBox<String> classrooms;
  @FXML private TableColumn<Student, String> idColumn;
  @FXML private TableColumn<Student, String> nameColumn;
  @FXML private TableColumn<Student, String> schoolFeesColumn;
  @FXML private TextField searchTextfield;
  @FXML private TableView<Student> tableView;

  public StudentListPage() throws SQLException {}

  @Override
  public void initialize(URL location, ResourceBundle resources) {}


}
