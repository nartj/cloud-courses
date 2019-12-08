package com.utbm.lo54.servicelayer.service;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseService {

    Course getCourse(Long id) throws ResourceNotFoundException;

    void save(Course course);

    List<Course> getCourses();

    void deleteCourse(Long id);
}
