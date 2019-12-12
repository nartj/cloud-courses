package com.utbm.lo54.accountservice.service;

import com.utbm.lo54.accountservice.dto.UserDto;
import com.utbm.lo54.accountservice.dto.UserLoginDto;
import com.utbm.lo54.accountservice.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.Map;

@FeignClient(name = "auth-service")
public interface AuthServiceFeignClient {

    @PostMapping(value = "/uaa/user")
    UserDto createUser(@RequestBody UserRegistrationDto user);

    @GetMapping(value = "/uaa/user/{username}")
    UserDto findByUsername(@PathVariable String username);

    @GetMapping(value = "/uaa/user/current")
    UserDto findCurrentUser(Principal principal);


}
