package com.utbm.lo54.adminwebapp.repository.impl;

import com.utbm.lo54.adminwebapp.repository.CourseRepository;
import com.utbm.lo54.common.domain.courses.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public String getServiceUrl() {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Course save(Course entity) {
        return null;
    }

    @Override
    public Course update(Course entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
