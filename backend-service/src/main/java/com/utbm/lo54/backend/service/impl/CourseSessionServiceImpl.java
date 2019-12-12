package com.utbm.lo54.backend.service.impl;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.repository.CourseSessionRepository;
import com.utbm.lo54.backend.service.CourseService;
import com.utbm.lo54.backend.service.CourseSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CourseSessionServiceImpl implements CourseSessionService {
    final static Logger logger = LoggerFactory.getLogger(CourseSessionServiceImpl.class);

    private final CourseSessionRepository courseSessionRepository;
    private final CourseService courseService;

    public CourseSessionServiceImpl(CourseSessionRepository courseSessionRepository, CourseService courseService) {
        this.courseSessionRepository = courseSessionRepository;
        this.courseService = courseService;
    }

    @Override
    public CourseSession getCourseSession(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course session with id " + id);
        return courseSessionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public void save(CourseSession newCourseSession) throws ResourceNotFoundException {

        Course course = courseService.getCourse(newCourseSession.getCourse().getId());
        List<CourseSession> courseSessions = courseService.getCourseSessions(course.getId());
        for (CourseSession courseSession : courseSessions)
            courseSession.setCourse(course);
        course.setCourseSessions(courseSessions);
        courseSessionRepository.attachCourse(course);
        logger.debug("New course session saved {}", courseSessionRepository.save(newCourseSession));
    }

    @Override
    public List<CourseSession> getCourseSessions() {
        return courseSessionRepository.findAll(new Date());
    }

    @Override
    public void deleteCourseSession(Long id) {
        courseSessionRepository.deleteById(id);
    }

    @Override
    public Course getCourseByCourseSessionId(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course session with id " + id);
        return courseSessionRepository.findCourseByCourseSessionId(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public List<CourseSession> getCourseSessionByCourseId(Long id) {
        return courseSessionRepository.findAllByCourseId(id);
    }
}
