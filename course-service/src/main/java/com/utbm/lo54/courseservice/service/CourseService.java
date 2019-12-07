package com.utbm.lo54.courseservice.service;

import com.utbm.lo54.core.domain.Course;
import com.utbm.lo54.core.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseService {

    Course getCourse(Long id) throws ResourceNotFoundException;

    void save(Course course);

    List<Course> getCourses();

    void deleteCourse(Long id);
}
