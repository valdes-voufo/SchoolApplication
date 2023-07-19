package com.cosmos.schoolapp.data.observer;

import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Student;

public interface LevelDataObserver {
  void onLevelUpdated(Level level);
}
