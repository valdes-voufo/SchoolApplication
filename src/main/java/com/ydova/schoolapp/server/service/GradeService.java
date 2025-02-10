package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.Grade;
import com.ydova.schoolapp.server.repository.GradeRepository;
import com.ydova.schoolapp.server.repository.RepositoryFactory;

import java.util.List;

public class GradeService {
    private  final GradeRepository gradeRepository;

    public GradeService() {
        this.gradeRepository = RepositoryFactory.getInstance(GradeRepository.class);
    }

    public void save(Grade entity) {
        this.gradeRepository.save(entity);
    }

    public Grade read(Long id) {
        return this.gradeRepository.read(id);
    }
    public List<Grade> readAll() {
        return this.gradeRepository.readAll();
    }
    public void update(Grade entity) {
        this.gradeRepository.update(entity);
    }
    public void delete(Long id) {
        this.gradeRepository.delete(id);
    }
}
