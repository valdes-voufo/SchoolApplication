package com.cosmos.schoolapp.observer;

import com.cosmos.schoolapp.entity.Student;

public interface StudentDataObserver {
  void onStudentUpdated(Student student);
}
