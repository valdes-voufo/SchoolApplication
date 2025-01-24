package com.ydova.schoolapp.service;

import com.ydova.schoolapp.entity.Classroom;
import com.ydova.schoolapp.entity.Level;
import com.ydova.schoolapp.entity.Section;
import com.ydova.schoolapp.repository.ClassroomRepository;
import com.ydova.schoolapp.repository.LevelRepository;
import com.ydova.schoolapp.repository.RepositoryFactory;
import com.ydova.schoolapp.repository.SectionRepository;

import java.util.List;

public class SchoolService{
    private final ClassroomRepository classroomRepository;
    private final SectionRepository sectionRepository;
    private final LevelRepository levelRepository;

    public SchoolService() {
        this.classroomRepository = RepositoryFactory.getInstance(ClassroomRepository.class);
        this.levelRepository = RepositoryFactory.getInstance(LevelRepository.class);
        this.sectionRepository = RepositoryFactory.getInstance(SectionRepository.class);
    }



    public void saveClassroom(Classroom entity) {
        classroomRepository.save(entity);
    }

    public void saveLevel(Level entity) {
        levelRepository.save(entity);
    }

    public void saveSection(Section entity) {
        sectionRepository.save(entity);
    }


    public void updateClassroom(Classroom entity) {
    classroomRepository.update(entity);
    }
    public void updateLevel(Level entity) {
        levelRepository.update(entity);
    }
    public void updateSection(Section entity) {
        sectionRepository.update(entity);
    }


    public Classroom readClassroom(Long aLong) {
       return classroomRepository.read(aLong);
    }

    public Level readLevel(Long aLong) {
        return levelRepository.read(aLong);
    }

    public Section readSection(Long aLong) {
        return sectionRepository.read(aLong);
    }

    public List<Classroom> readAllClassrooms() {
        return classroomRepository.readAll();
    }
    public List<Level> readAllLevels() {
        return levelRepository.readAll();
    }
    public List<Section> readAllSections() {
        return sectionRepository.readAll();
    }


    public void deleteClassroom(Long aLong) {
classroomRepository.delete(aLong);
    }
    public void deleteLevel(Long aLong) {
        levelRepository.delete(aLong);
    }
    public void deleteSection(Long aLong) {
        sectionRepository.delete(aLong);
    }

}
