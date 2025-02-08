package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.*;
import com.ydova.schoolapp.server.repository.*;

import java.util.List;

public class SchoolService{
    private final ClassroomRepository classroomRepository;
    private final SectionRepository sectionRepository;
    private final LevelRepository levelRepository;
    private final CouresRepository couresRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final GradleRepository gradleRepository;

    public SchoolService() {
        this.couresRepository = RepositoryFactory.getInstance(CouresRepository.class);
        this.classroomRepository = RepositoryFactory.getInstance(ClassroomRepository.class);
        this.levelRepository = RepositoryFactory.getInstance(LevelRepository.class);
        this.sectionRepository = RepositoryFactory.getInstance(SectionRepository.class);
        this.teacherRepository = RepositoryFactory.getInstance(TeacherRepository.class);
        this.gradleRepository = RepositoryFactory.getInstance(GradleRepository.class);
        this.userRepository = RepositoryFactory.getInstance(UserRepository.class);

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

    public boolean saveUser(User entity) {
        List<User> listUser = userRepository.readAll();
        for (User user1 : listUser) {
            if(entity.getId()==user1.getId()) {
                return false;
            }
        }
        userRepository.save(entity);
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
    public void updateTeacher(Teacher entity) {teacherRepository.update(entity);}
    public void updateUser(User entity) {userRepository.update(entity);}



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
    public Teacher readTeacher(Long aLong) {return teacherRepository.read(aLong);}
    public User readUser(Long aLong) {return userRepository.read(aLong);}

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
    public List<Teacher> readAllTeachers() {return teacherRepository.readAll();}
    public List<User> readAllUsers() {return userRepository.readAll();}


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
    public void deleteTeacher(Long aLong) {teacherRepository.delete(aLong);}
    public void deleteUser(Long aLong) {userRepository.delete(aLong);}

}
