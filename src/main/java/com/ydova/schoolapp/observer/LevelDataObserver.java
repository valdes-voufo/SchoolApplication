package com.ydova.schoolapp.observer;

import com.ydova.schoolapp.entity.Level;

public interface LevelDataObserver {
  void onLevelUpdated(Level level);
}
