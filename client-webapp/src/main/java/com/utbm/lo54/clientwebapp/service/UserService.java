package com.utbm.lo54.clientwebapp.service;

import com.utbm.lo54.common.domain.security.User;

public interface UserService {
    User findByUserName(String userName);

    User save(User userForm);
}
