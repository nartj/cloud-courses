package com.utbm.lo54.courseservice.service.impl;

import com.utbm.lo54.core.courses.domain.Course;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import com.utbm.lo54.courseservice.repository.CourseRepository;
import com.utbm.lo54.courseservice.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("coursesPlatformTransactionManager")
public class CourseServiceImpl implements CourseService {
    final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Transactional("coursesPlatformTransactionManager")
    @Override
    public Course getCourse(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course with id " + id);
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Transactional("coursesPlatformTransactionManager")
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
