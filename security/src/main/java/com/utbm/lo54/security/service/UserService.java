package com.utbm.lo54.security.service;


import com.utbm.lo54.security.domain.User;

public interface UserService {
    User create(User user);
    User findByUsername(String username);
}
