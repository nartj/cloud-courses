package com.utbm.lo54.accountservice.controller;

import com.utbm.lo54.accountservice.dto.UserDto;
import com.utbm.lo54.accountservice.dto.UserLoginDto;
import com.utbm.lo54.accountservice.dto.UserRegistrationDto;
import com.utbm.lo54.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController("/user")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public UserDto createNewAccount(@RequestBody UserRegistrationDto user) {
        return accountService.create(user);
    }

    @GetMapping("/{username}")
    public UserDto findByUsername(@PathVariable String username) { return accountService.findByUsername(username); }

    @GetMapping("/current")
    public  UserDto findCurrentUser() { { return accountService.findCurrentUser(); } }

}
