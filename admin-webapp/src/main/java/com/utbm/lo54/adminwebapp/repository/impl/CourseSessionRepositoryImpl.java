package com.utbm.lo54.adminwebapp.repository.impl;

import com.utbm.lo54.adminwebapp.repository.CourseSessionRepository;
import com.utbm.lo54.common.domain.courses.CourseSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseSessionRepositoryImpl implements CourseSessionRepository {
    @Override
    public String getServiceUrl() {
        return null;
    }

    @Override
    public List<CourseSession> findAll() {
        return null;
    }

    @Override
    public Optional<CourseSession> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CourseSession save(CourseSession entity) {
        return null;
    }

    @Override
    public CourseSession update(CourseSession entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
