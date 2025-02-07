package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.Classroom;
import com.ydova.schoolapp.server.entity.Course;
import com.ydova.schoolapp.server.entity.Level;
import com.ydova.schoolapp.server.entity.Section;
import com.ydova.schoolapp.server.repository.*;

import java.util.List;

public class SchoolService{
    private final ClassroomRepository classroomRepository;
    private final SectionRepository sectionRepository;
    private final LevelRepository levelRepository;
    private final CouresRepository couresRepository;

    public SchoolService() {
        this.couresRepository = RepositoryFactory.getInstance(CouresRepository.class);
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

    public boolean saveCoures(Course entity) {
        List<Course> listCoures = couresRepository.readAll();
        for (Course course : listCoures) {
            if (entity.getName().equals(course.getName())) {
                return false;
            }
        }
        couresRepository.save(entity);
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
    public void updateCourses(Course entity) {couresRepository.update(entity);}



    public Classroom readClassroom(Long id) {
       return classroomRepository.read(id);
    }
    public Level readLevel(Long aLong) {
        return levelRepository.read(aLong);
    }
    public Section readSection(Long aLong) {
        return sectionRepository.read(aLong);
    }
    public Course readCoures(Long aLong) {return couresRepository.read(aLong);}

    public List<Classroom> readAllClassrooms() {
        return classroomRepository.readAll();
    }
    public List<Level> readAllLevels() {
        return levelRepository.readAll();
    }
    public List<Section> readAllSections() {
        return sectionRepository.readAll();
    }
    public List<Course> readAllCoures() {return couresRepository.readAll();}


    public void deleteClassroom(Long aLong) {
classroomRepository.delete(aLong);
    }
    public void deleteLevel(Long aLong) {
        levelRepository.delete(aLong);
    }
    public void deleteSection(Long aLong) {
        sectionRepository.delete(aLong);
    }
    public void deleteCoures(Long aLong) {couresRepository.delete(aLong);}

}
