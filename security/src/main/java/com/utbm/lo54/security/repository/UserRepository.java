package com.utbm.lo54.security.repository;

import com.utbm.lo54.security.domain.User;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
