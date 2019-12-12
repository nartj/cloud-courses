package com.utbm.lo54.backend.repository;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c.courseSessions from Course c where c.id = :id")
    List<CourseSession> getCoursesSessions(Long id);

    @Query("select c from Course c where c.title like %:search%")
    List<Course> filterAllByTitle(String search);

    @Query("select c from Course c join c.courseSessions cs where cs.location.id = :id")
    List<Course> findAllByLocationId(Long id);

    @Query("select c from Course c join c.courseSessions cs where cs.startDate = :date")
    List<Course> findAllBySessionStartDate(Date date);
}
