package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.*;
import com.ydova.schoolapp.server.repository.*;

import java.util.List;

public class SchoolService{
    private final ClassroomRepository classroomRepository;
    private final SectionRepository sectionRepository;
    private final LevelRepository levelRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public SchoolService() {
        this.courseRepository = RepositoryFactory.getInstance(CourseRepository.class);
        this.classroomRepository = RepositoryFactory.getInstance(ClassroomRepository.class);
        this.levelRepository = RepositoryFactory.getInstance(LevelRepository.class);
        this.sectionRepository = RepositoryFactory.getInstance(SectionRepository.class);
        this.teacherRepository = RepositoryFactory.getInstance(TeacherRepository.class);
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

    public boolean saveCourse(Course entity) {
        List<Course> courses = courseRepository.readAll();
        for (Course course : courses) {
            if (entity.getName().equals(course.getName())) {
                return false;
            }
        }
        courseRepository.save(entity);
        return true;
    }

    public boolean saveTeacher(Teacher entity) {
        List<Teacher> listTeachers = teacherRepository.readAll();
        for (Teacher teacher : listTeachers) {
            if (entity.getId()==teacher.getId()) {
                return false;
            }
        }
        teacherRepository.save(entity);
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
    public void updateCourse(Course entity) {
        courseRepository.update(entity);
    }
    public void updateTeacher(Teacher entity) {teacherRepository.update(entity);}



    public Classroom readClassroom(Long id) {
       return classroomRepository.read(id);
    }
    public Level readLevel(Long aLong) {
        return levelRepository.read(aLong);
    }
    public Section readSection(Long aLong) {
        return sectionRepository.read(aLong);
    }
    public Course readCourse(Long id) {
        return courseRepository.read(id);
    }
    public Teacher readTeacher(Long aLong) {return teacherRepository.read(aLong);}

    public List<Classroom> readAllClassrooms() {
        return classroomRepository.readAll();
    }
    public List<Level> readAllLevels() {
        return levelRepository.readAll();
    }
    public List<Section> readAllSections() {
        return sectionRepository.readAll();
    }
    public List<Course> readAllCourses() {
        return courseRepository.readAll();
    }
    public List<Teacher> readAllTeachers() {return teacherRepository.readAll();}



    public void deleteClassroom(Long aLong) {
classroomRepository.delete(aLong);
    }
    public void deleteLevel(Long aLong) {
        levelRepository.delete(aLong);
    }
    public void deleteSection(Long aLong) {
        sectionRepository.delete(aLong);
    }
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }
    public void deleteTeacher(Long aLong) {teacherRepository.delete(aLong);}


}
