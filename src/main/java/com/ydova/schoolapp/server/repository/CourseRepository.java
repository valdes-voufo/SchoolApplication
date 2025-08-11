package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Course;

/**
 * Repository handling {@link Course} entities.
 *
 * <p>The previous implementation misspelled the class name as
 * {@code CouresRepository}, which could lead to confusion and
 * difficulties when attempting to retrieve the repository from the
 * {@link RepositoryFactory}. The typo is corrected to keep a consistent
 * naming convention across the application.</p>
 */
public class CourseRepository extends YRepository<Course, Long> {

    public CourseRepository() {
        super(Course.class);
    }
}
