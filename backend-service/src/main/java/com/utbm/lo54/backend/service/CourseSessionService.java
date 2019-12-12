package com.utbm.lo54.backend.service;


import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseSessionService {

    CourseSession getCourseSession(Long id) throws ResourceNotFoundException;

    void save(CourseSession courseSession) throws ResourceNotFoundException;

    List<CourseSession> getCourseSessions();

    void deleteCourseSession(Long id);

    Course getCourseByCourseSessionId(Long id) throws ResourceNotFoundException;

    List<CourseSession> getCourseSessionByCourseId(Long id);

}
