package com.ydova.schoolapp.repository;

import com.ydova.schoolapp.entity.Level;

public class LevelRepository extends YRepository<Level, Long> {
    public LevelRepository() {
        super(Level.class);
    }
}
