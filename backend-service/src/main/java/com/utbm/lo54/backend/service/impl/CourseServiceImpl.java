package com.utbm.lo54.backend.service.impl;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.repository.CourseRepository;
import com.utbm.lo54.backend.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        List<CourseSession> courseSessions = getCourseSessions(newCourse.getId());
        for (CourseSession courseSession : courseSessions)
            courseSession.setCourse(newCourse);
        newCourse.setCourseSessions(courseSessions);
        logger.debug("New Course saved {}", courseRepository.save(newCourse));
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseSession> getCourseSessions(Long id) {
        return courseRepository.getCoursesSessions(id);
    }

    @Override
    public List<Course> filterCoursesByTitle(String search) {
        return courseRepository.filterAllByTitle(search);
    }

    @Override
    public List<Course> filterCoursesByLocationId(Long id) {
        return courseRepository.findAllByLocationId(id);
    }

    @Override
    public List<Course> filterCoursesByDate(Date date) {
        return courseRepository.findAllBySessionStartDate(date);
    }
}
