package com.utbm.lo54.clientwebapp.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface HttpRepository<T> {

    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T entity);
    T update(T entity);
    void deleteById(Long id);

}
