package com.utbm.lo54.coursesessionservice.repository;

import com.utbm.lo54.common.domain.courses.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {

}
