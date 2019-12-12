package com.utbm.lo54.backend.repository.impl;

import com.utbm.lo54.common.domain.courses.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CourseSessionRepositoryImpl implements CourseSessionRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void attachCourse(Course course) {
        em.persist(course);
    }
}
