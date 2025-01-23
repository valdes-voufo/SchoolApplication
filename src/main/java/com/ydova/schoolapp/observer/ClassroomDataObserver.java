package com.ydova.schoolapp.observer;

import com.ydova.schoolapp.entity.ClassRoom;

public interface ClassroomDataObserver {
  void onClassroomUpdated(ClassRoom classRoom);
}
