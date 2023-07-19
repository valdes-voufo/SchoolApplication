package com.cosmos.schoolapp.data.observer;

import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.data.StudentStatus;

import java.time.LocalDate;

public interface StudentDataObserver {
  void onStudentUpdated(Student student);
}
