package com.utbm.lo54.clientwebapp.service.impl;

import com.utbm.lo54.clientwebapp.repository.CourseRepository;
import com.utbm.lo54.clientwebapp.service.CourseService;
import com.utbm.lo54.core.domain.Course;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course with id " + id);
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

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
