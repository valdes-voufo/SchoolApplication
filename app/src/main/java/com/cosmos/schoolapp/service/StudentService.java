package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.entity.Student;
import com.cosmos.schoolapp.repository.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student getStudentByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository
    return studentRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public ObservableList<Student> getAllStudents() {
    List<Student> users = studentRepository.findAll();
    return FXCollections.observableArrayList(users);
  }

  public void saveStudent(Student user) {
    studentRepository.save(user);
  }
}
