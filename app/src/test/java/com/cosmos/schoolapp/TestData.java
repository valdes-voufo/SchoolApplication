package com.cosmos.schoolapp;

import com.cosmos.schoolapp.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestData {
  public static List<Student> getStudentList() {
    Student student =
        DataMill.studentBuilder()
            .studentId(1)
            .studentFee(1000.0)
            .firstname("Sagesse Valdes")
            .lastname("Dongmo Voufo")
            .build();

    List<Student> students = new ArrayList<>();
    students.add(student);
    return students;
  }
}
