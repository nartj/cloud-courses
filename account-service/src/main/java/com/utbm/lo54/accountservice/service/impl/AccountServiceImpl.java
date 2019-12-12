package com.utbm.lo54.accountservice.service.impl;

import com.utbm.lo54.accountservice.dto.UserDto;
import com.utbm.lo54.accountservice.dto.UserLoginDto;
import com.utbm.lo54.accountservice.dto.UserRegistrationDto;
import com.utbm.lo54.accountservice.service.AccountService;
import com.utbm.lo54.accountservice.service.AuthServiceFeignClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    private final AuthServiceFeignClient authServiceFeignClient;

    public AccountServiceImpl(AuthServiceFeignClient authServiceFeignClient) {
        this.authServiceFeignClient = authServiceFeignClient;
    }

    @Override
    public UserDto create(UserRegistrationDto user) {
        return authServiceFeignClient.createUser(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        return authServiceFeignClient.findByUsername(username);
    }

    @Override
    public UserDto findCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authServiceFeignClient.findCurrentUser((Principal)authentication.getPrincipal());
    }

}
