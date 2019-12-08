package com.utbm.lo54.courseservice.repository;

import com.utbm.lo54.common.domain.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
