package com.utbm.lo54.clientwebapp.service;


import com.utbm.lo54.core.courses.domain.Course;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface CourseService {
    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    Course getCourse(Long id) throws ResourceNotFoundException;

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    void save(Course course);

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    List<Course> getCourses();

    @Secured({"ROLE_ADMIN"})
    void deleteCourse(Long id);
}
