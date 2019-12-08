package com.utbm.lo54.servicelayer.service.impl;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.repository.CourseRepository;
import com.utbm.lo54.servicelayer.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Override
    public Course getCourse(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course with id " + id);
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Transactional
    @Override
    public void save(Course newCourse) {
        Course course = courseRepository.save(newCourse);
        logger.debug("New Course saved " + course);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
