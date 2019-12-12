package com.utbm.lo54.backend.repository;

import com.utbm.lo54.common.domain.courses.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select count(c) from Client c where c.courseSession.id = :id")
    Integer countClientByCourseSessionId(Long id);
}