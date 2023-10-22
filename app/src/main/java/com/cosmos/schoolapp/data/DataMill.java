package com.cosmos.schoolapp.data;

import com.cosmos.schoolapp.data.entity.Student;

public class DataMill {
  public static Student.StudentBuilder studentBuilder() {
    return Student.builder();
  }


}
