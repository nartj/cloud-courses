package com.utbm.lo54.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthenticationResourceController {

    @RequestMapping("/authenticate")
    public String demo(Principal principal) {
        return "Hello "+principal.getName()+", Auth 2.0 Resource Server, Access Granted by authentication server..";
    }
}
