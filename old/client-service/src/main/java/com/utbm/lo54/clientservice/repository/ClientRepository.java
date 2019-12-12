package com.utbm.lo54.clientservice.repository;

import com.utbm.lo54.common.domain.courses.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}