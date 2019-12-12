package com.utbm.lo54.accountservice.service;

import com.utbm.lo54.accountservice.dto.UserDto;
import com.utbm.lo54.accountservice.dto.UserLoginDto;
import com.utbm.lo54.accountservice.dto.UserRegistrationDto;

import java.security.Principal;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);

    UserDto findByUsername(String username);

    UserDto findCurrentUser();
}
