//package com.utbm.lo54.zuul.controller;
//
//import com.utbm.lo54.zuul.service.SecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/security")
//public class SecurityController {
//
//    @Autowired
//    private SecurityService securityService;
//
//    @GetMapping("/current-user/username")
//    public ResponseEntity<String> findCurrentLoggedUsername() {
//        return ResponseEntity.of(Optional.of(securityService.findLoggedInUsername()));
//    }
//
//    @PostMapping("/current-user/autolog")
//    public void autoLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
//        securityService.autoLogin(username, password);
//    }
//}
