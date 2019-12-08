package com.utbm.lo54.security.controller;

import com.utbm.lo54.common.domain.security.User;
import com.utbm.lo54.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{username}")
    public User findByUserName(@RequestBody String userName) {
        return userService.findByUsername(userName);
    }
}
