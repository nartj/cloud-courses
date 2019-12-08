package com.utbm.lo54.servicelayer.service;


import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseSessionService {

    CourseSession getCourseSession(Long id) throws ResourceNotFoundException;

    void save(CourseSession courseSession);

    List<CourseSession> getCourseSessions();

    void deleteCourseSession(Long id);
}
