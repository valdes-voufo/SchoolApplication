package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Level;

public class LevelRepository extends YRepository<Level, Long> {
    public LevelRepository() {
        super(Level.class);
    }
}
