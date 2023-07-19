package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.data.DataObserver;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.swing.text.html.ListView;
import java.util.List;

// TODO: 19.07.2023 procedure to perform live updates.
public class StudentController implements DataObserver<Student> {
  private ObservableList<Student> studentsData = FXCollections.observableArrayList();

  private StudentService studentService;

  @FXML private ComboBox<Student> studentListView;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @FXML
  public void initialize() {
    studentService.addObserver(this);
    refreshStudentsData();
    studentListView.setItems(studentsData);
  }

  @FXML
  public void onSaveStudentButtonClicked() {
    // Code to handle saving a new student
    Student newStudent = new Student();
    newStudent.setAdresse("New Student");
    newStudent.setStudentId(20);
    studentService.saveStudent(newStudent);
  }

  @FXML
  public void onUpdateStudentButtonClicked() {
    // Code to handle updating an existing student (assuming selectedStudent is set)
    Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
    if (selectedStudent != null) {
      selectedStudent.setFatherName("Updated Student");
      studentService.saveStudent(selectedStudent);
    }
  }

  @FXML
  public void onDeleteStudentButtonClicked() {
    // Code to handle deleting an existing student (assuming selectedStudent is set)
    Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
    if (selectedStudent != null) {
      studentService.saveStudent(selectedStudent);
    }
  }

  private void refreshStudentsData() {
    List<Student> studentsFromDatabase = studentService.getAllStudents();
    studentsData.setAll(studentsFromDatabase);
  }

  @Override
  public void onDataUpdated(Student data) {
    refreshStudentsData();
  }
}
