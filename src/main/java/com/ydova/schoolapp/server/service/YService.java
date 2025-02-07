package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.Classroom;

public interface YService <T,ID>{


    void save(Classroom entity);
}
