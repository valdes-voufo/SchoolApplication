package com.ydova.schoolapp.repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryFactory {
   private static final Map<Class<?>,Object> repositories= new HashMap<>();

   @SuppressWarnings("unchecked")
    public  static <T> T getInstance(Class<T> clazz) {
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
        else {
            throw new IllegalArgumentException("Unsupported repository type: " + clazz);
        }
   }
}
