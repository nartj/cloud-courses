package com.utbm.lo54.webapp.service;


import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseSessionService {
    CourseSessionDto getCourseSession(Long id) throws ResourceNotFoundException;

    void save(CourseSessionDto courseSession);

    List<CourseSessionDto> getCourseSessions();

    void deleteCourseSession(Long id);

    List<CourseSessionDto> getCourseSessionsByCourseId(Long id);

    Integer getCourseSessionFilling(Long id);
}
