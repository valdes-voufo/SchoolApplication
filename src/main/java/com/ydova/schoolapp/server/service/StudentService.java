package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.Student;
import com.ydova.schoolapp.server.repository.RepositoryFactory;
import com.ydova.schoolapp.server.repository.StudentRepository;

import java.util.List;

public class StudentService  {
  private  final   StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = RepositoryFactory.getInstance(StudentRepository.class);
    }

    public void save(Student entity) {
        this.studentRepository.save(entity);
    }

    public Student read(Long id) {
        return this.studentRepository.read(id);
    }
    public List<Student> readAll() {
        return this.studentRepository.readAll();
    }
    public void update(Student entity) {
        this.studentRepository.update(entity);
    }
    public void delete(Long id) {
        this.studentRepository.delete(id);
    }

}
