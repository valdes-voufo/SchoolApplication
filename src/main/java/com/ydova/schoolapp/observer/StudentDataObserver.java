package com.ydova.schoolapp.observer;

import com.ydova.schoolapp.entity.Student;

public interface StudentDataObserver {
  void onStudentUpdated(Student student);
}
