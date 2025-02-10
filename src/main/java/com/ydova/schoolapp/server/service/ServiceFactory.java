package com.ydova.schoolapp.server.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    // Map to store services with their respective class types
    private static final Map<Class<?>, Object> services = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        // Check if the service instance already exists
        if (services.containsKey(clazz)) {
            return (T) services.get(clazz);
        }

        // Create and store a new instance if not found
        if (clazz.equals(StudentService.class)) {
            StudentService studentService = new StudentService();
            services.put(clazz, studentService);
            return (T) studentService;
        }
        // Create and store a new instance if not found
      else   if (clazz.equals(SchoolService.class)) {
            SchoolService schoolService = new SchoolService();
            services.put(clazz, schoolService);
            return (T) schoolService;
        }
        else   if (clazz.equals(UserService.class)) {
            UserService userService = new UserService();
            services.put(clazz, userService);
            return (T) userService;
        }
        else   if (clazz.equals(GradeService.class)) {
            GradeService gradeService = new GradeService();
            services.put(clazz, gradeService);
            return (T) gradeService;
        }
        else {
            throw new IllegalArgumentException("No implementation available for: " + clazz.getName());
        }
    }
}
