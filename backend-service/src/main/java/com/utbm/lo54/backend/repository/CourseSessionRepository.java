package com.utbm.lo54.backend.repository;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.backend.repository.impl.CourseSessionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long>, CourseSessionRepositoryCustom {
    void attachCourse(Course course);

    @Query("select cs.course from CourseSession cs where cs.id = :id")
    Optional<Course> findCourseByCourseSessionId(Long id);

    List<CourseSession> findAllByCourseId(Long id);

    @Query("select cs from CourseSession cs where cs.endDate >= :today order by cs.startDate")
    List<CourseSession> findAll(Date today);

}
