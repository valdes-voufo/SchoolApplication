package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.data.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

  @Mock private StudentRepository studentRepository;

  @InjectMocks private StudentService studentService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetAllStudents() {
    // Create a list of students
    List<Student> students = TestData.getStudentList();

    // Mock the behavior of the student repository
    when(studentRepository.findAll()).thenReturn(students);

    // Call the service method
    List<Student> result = studentService.getAllStudents();

    // Verify the result
    assertEquals(students, result);

    // Verify that the repository method was called
    verify(studentRepository, times(1)).findAll();
  }
}
