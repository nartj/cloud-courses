package com.utbm.lo54.clientwebapp.repository;

import com.utbm.lo54.clientwebapp.repository.http.HttpRepository;
import com.utbm.lo54.core.domain.Course;
import org.springframework.stereotype.Repository;

public interface CourseRepository extends HttpRepository<Course> {
}
