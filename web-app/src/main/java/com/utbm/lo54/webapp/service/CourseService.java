package com.utbm.lo54.webapp.service;


import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public interface CourseService {
    CourseDto getCourse(Long id) throws ResourceNotFoundException;

    void save(CourseDto course);

    List<CourseDto> getCourses();

    void deleteCourse(Long id);

    List<CourseDto> searchTitle(String search);

    List<CourseDto> searchLocation(Long id);

    List<CourseDto> searchDate(Date date);
}
