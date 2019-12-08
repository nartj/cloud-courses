package com.utbm.lo54.security.service;


import com.utbm.lo54.common.domain.security.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User save(User user);

    User findByUsername(String username);

}
