package com.cosmos.schoolapp;

import com.cosmos.schoolapp.data.observer.StudentDataObserver;
import com.cosmos.schoolapp.data.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestData {
  public static List<Student> getStudentList() {
    Student student =
        new StudentDataObserver()
            .setStudentId(1)
            .setStudentFee(1000.0)
            .setFirstname("Sagesse Valdes")
            .setLastname("Dongmo Voufo")
            .build();

    List<Student> students = new ArrayList<>();
    students.add(student);
    return students;
  }
}
