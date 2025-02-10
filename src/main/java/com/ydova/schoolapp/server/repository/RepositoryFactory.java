package com.ydova.schoolapp.server.repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryFactory {
   private static final Map<Class<?>,Object> repositories= new HashMap<>();

   @SuppressWarnings("unchecked")
    public  static <T> T getInstance(Class<T> clazz) {
       // si javais deja crrer je revoies l instance que javais dej creer
        if(repositories.containsKey(clazz)) {
            return  (T) repositories.get(clazz);
        }

        if (clazz.equals(StudentRepository.class)) {
            StudentRepository studentRepository = new StudentRepository();
            repositories.put(StudentRepository.class, studentRepository);
            return (T) studentRepository;
        }
        else if (clazz.equals(ClassroomRepository.class)) {
            ClassroomRepository classroomRepository = new ClassroomRepository();
            repositories.put(ClassroomRepository.class, classroomRepository);
            return (T) classroomRepository;
        } else if (clazz.equals(SectionRepository.class)) {
            SectionRepository sectionRepository = new SectionRepository();
            repositories.put(SectionRepository.class, sectionRepository);
            return (T) sectionRepository;
        }
        else if (clazz.equals(LevelRepository.class)) {
            LevelRepository levelRepository = new LevelRepository();
            repositories.put(LevelRepository.class, levelRepository);
            return (T) levelRepository;
        }
        else if (clazz.equals(CouresRepository.class)) {
            CouresRepository couresRepository = new CouresRepository();
            repositories.put(CouresRepository.class, couresRepository);
            return (T) couresRepository;
        }
        else if (clazz.equals(GradeRepository.class)) {
            GradeRepository gradeRepository = new GradeRepository();
            repositories.put(GradeRepository.class, gradeRepository);
            return (T) gradeRepository;
        }
        else if (clazz.equals(TeacherRepository.class)) {
            TeacherRepository teacherRepository = new TeacherRepository();
            repositories.put(TeacherRepository.class, teacherRepository);
            return (T) teacherRepository;
        }
        else if (clazz.equals(UserRepository.class)) {
            UserRepository userRepository = new UserRepository();
            repositories.put(UserRepository.class, userRepository);
            return (T) userRepository;
        }
        else {
            throw new IllegalArgumentException("Unsupported repository type: " + clazz);
        }
   }
}
