package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.data.RepositoryListener;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.data.repository.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
  private final StudentRepository studentRepository;
  // private List<RepositoryListener<Student>> listeners = new ArrayList<>();

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student getStudentByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository
    return studentRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public ObservableList<Student> getAllStudents() {
    List<Student> users = (List<Student>) studentRepository.findAll();
    return FXCollections.observableArrayList(users);
  }

  public void saveStudent(Student user) {
    studentRepository.save(user);
    /*  for (RepositoryListener<Student> listener : listeners) {
      listener.onUserChange(user);
    }*/
  }

  public void addStudentChangeListener(RepositoryListener<Student> listener) {
    // listeners.add(listener);
  }
}
