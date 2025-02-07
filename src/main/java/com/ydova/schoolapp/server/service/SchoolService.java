package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.Classroom;
import com.ydova.schoolapp.server.entity.Level;
import com.ydova.schoolapp.server.entity.Section;
import com.ydova.schoolapp.server.repository.ClassroomRepository;
import com.ydova.schoolapp.server.repository.LevelRepository;
import com.ydova.schoolapp.server.repository.RepositoryFactory;
import com.ydova.schoolapp.server.repository.SectionRepository;

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



    public boolean saveClassroom(Classroom entity) {
        List<Classroom> listClassroom=  classroomRepository.readAll();
        for (Classroom classroom : listClassroom) {
            if (entity.getName().equals(classroom.getName())) {
                return false;
            }
        }
        classroomRepository.save(entity);
        return true;
    }

    public boolean saveLevel(Level entity) {
        List<Level> listLevel = levelRepository.readAll();
        for (Level level : listLevel) {
            if (level.getName().equals(entity.getName())) {
                return false;
            }
        }
        levelRepository.save(entity);
        return true;
    }

    public boolean saveSection(Section entity) {
        List<Section> listSection = sectionRepository.readAll();
        for (Section section : listSection) {
            if (section.getName().equals(entity.getName())) {
                return false;
            }
        }
        sectionRepository.save(entity);
        return true;
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
