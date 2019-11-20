package com.utbm.lo54.adminwebapp.repository;

import com.utbm.lo54.adminwebapp.repository.http.HttpRepository;
import com.utbm.lo54.core.courses.domain.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends HttpRepository<Course> {
}
