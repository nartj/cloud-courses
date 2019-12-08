package com.utbm.lo54.servicelayer.service.impl;

import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.repository.CourseSessionRepository;
import com.utbm.lo54.servicelayer.service.CourseSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseSessionServiceImpl implements CourseSessionService {
    final static Logger logger = LoggerFactory.getLogger(CourseSessionServiceImpl.class);


    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Override
    public CourseSession getCourseSession(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course session with id " + id);
        return courseSessionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public void save(CourseSession newCourseSession) {
        CourseSession courseSession = courseSessionRepository.save(newCourseSession);
        logger.debug("New course session saved " + courseSession);
    }

    @Override
    public List<CourseSession> getCourseSessions() {
        return courseSessionRepository.findAll();
    }

    @Override
    public void deleteCourseSession(Long id) {
        courseSessionRepository.deleteById(id);
    }
}
