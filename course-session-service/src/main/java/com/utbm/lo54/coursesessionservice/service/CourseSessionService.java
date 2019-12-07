package com.utbm.lo54.coursesessionservice.service;


import com.utbm.lo54.core.domain.CourseSession;
import com.utbm.lo54.core.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseSessionService {

    CourseSession getCourseSession(Long id) throws ResourceNotFoundException;

    void save(CourseSession courseSession);

    List<CourseSession> getCourseSessions();

    void deleteCourseSession(Long id);
}
