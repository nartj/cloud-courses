package com.utbm.lo54.security.service;


import com.utbm.lo54.security.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
