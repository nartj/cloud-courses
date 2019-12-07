package com.utbm.lo54.clientwebapp.service;


import com.utbm.lo54.core.domain.CourseSession;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface CourseSessionService {
    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    CourseSession getCourseSession(Long id) throws ResourceNotFoundException;

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    void save(CourseSession courseSession);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    List<CourseSession> getCourseSessions();

    @Secured ({"ROLE_ADMIN"})
    void deleteCourseSession(Long id);

}
