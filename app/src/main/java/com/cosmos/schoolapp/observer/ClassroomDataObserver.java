package com.cosmos.schoolapp.observer;

import com.cosmos.schoolapp.entity.ClassRoom;

public interface ClassroomDataObserver {
  void onClassroomUpdated(ClassRoom classRoom);
}
