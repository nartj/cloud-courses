package com.utbm.lo54.clientwebapp.repository;

import com.utbm.lo54.clientwebapp.repository.HttpRepository;
import com.utbm.lo54.common.domain.security.User;

public interface UserRepository {
    User findByUserName(String userName);

    User save(User user);
}
