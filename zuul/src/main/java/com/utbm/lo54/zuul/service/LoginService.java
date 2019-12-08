//package com.utbm.lo54.zuul.service;
//
//import com.utbm.lo54.common.domain.security.User;
//import com.utbm.lo54.zuul.domain.AuthResponse;
//import com.utbm.lo54.zuul.domain.LoginRequest;
//import com.utbm.lo54.zuul.security.exception.CustomException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public interface LoginService {
//    String login(String username, String password) throws CustomException;
//
//    boolean logout(String token);
//
//    Boolean isValidToken(String token);
//
//    String createNewToken(String token);
//
//}
