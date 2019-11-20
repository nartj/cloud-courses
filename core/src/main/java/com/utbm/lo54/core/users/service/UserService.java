package com.utbm.lo54.core.users.service;


import com.utbm.lo54.core.users.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
