package com.cosmos.schoolapp.observer;

import com.cosmos.schoolapp.entity.Level;

public interface LevelDataObserver {
  void onLevelUpdated(Level level);
}
