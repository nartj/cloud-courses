package com.utbm.lo54.adminwebapp.service.impl;

import com.utbm.lo54.adminwebapp.repository.CourseSessionRepository;
import com.utbm.lo54.adminwebapp.service.CourseSessionService;
import com.utbm.lo54.core.domain.CourseSession;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseSessionServiceImpl implements CourseSessionService {
    final static Logger logger = LoggerFactory.getLogger(CourseSessionServiceImpl.class);

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Transactional
    @Override
    public CourseSession getCourseSession(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course session with id " + id);
        return courseSessionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Transactional
    @Override
    public void save(CourseSession newCourseSession) {
        CourseSession courseSession = courseSessionRepository.save(newCourseSession);
        logger.debug("New course session saved " + courseSession);
    }

    @Transactional
    @Override
    public List<CourseSession> getCourseSessions() {
        return courseSessionRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteCourseSession(Long id) {
        courseSessionRepository.deleteById(id);
    }
}
