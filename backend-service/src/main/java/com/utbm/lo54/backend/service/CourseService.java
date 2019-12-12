package com.utbm.lo54.backend.service;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public interface CourseService {

    Course getCourse(Long id) throws ResourceNotFoundException;

    void save(Course course);

    List<Course> getCourses();

    void deleteCourse(Long id);

    List<CourseSession> getCourseSessions(Long id);

    List<Course> filterCoursesByTitle(String search);

    List<Course> filterCoursesByLocationId(Long id);

    List<Course> filterCoursesByDate(Date date);
}
