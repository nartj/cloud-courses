package com.utbm.lo54.coursesessionservice.repository;

import com.utbm.lo54.core.courses.domain.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {

}
