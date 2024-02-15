package com.cosmos.schoolapp;

import com.cosmos.schoolapp.entity.Student;

public class DataMill {
  public static Student.StudentBuilder studentBuilder() {
    return Student.builder();
  }
}
