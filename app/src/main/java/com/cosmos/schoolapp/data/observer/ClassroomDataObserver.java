package com.cosmos.schoolapp.data.observer;

import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Student;

public interface ClassroomDataObserver {
  void onClassroomUpdated(ClassRoom classRoom);
}
