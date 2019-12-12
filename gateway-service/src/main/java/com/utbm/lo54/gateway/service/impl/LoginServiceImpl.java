//package com.utbm.lo54.zuul.service.impl;
//
//import com.utbm.lo54.common.domain.security.Role;
//import com.utbm.lo54.common.domain.security.User;
//import com.utbm.lo54.zuul.domain.JwtToken;
//import com.utbm.lo54.zuul.repository.JwtTokenRepository;
//import com.utbm.lo54.zuul.repository.UserRepository;
//import com.utbm.lo54.zuul.security.JwtTokenProvider;
//import com.utbm.lo54.zuul.security.exception.CustomException;
//import com.utbm.lo54.zuul.service.LoginService;
//import com.utbm.lo54.zuul.service.SecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Service
//public class LoginServiceImpl implements LoginService {
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private JwtTokenRepository jwtTokenRepository;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public String login(String username, String password) throws CustomException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
//                    password));
//            User user = userRepository.findByUsername(username);
//            if (user == null || user.getRoles() == null || user.getRoles().isEmpty()) {
//                throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
//            }
//            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
//            //Since we are using custom token using JWT we should add ROLE_ prefix
//            return jwtTokenProvider.createToken(username, user.getRoles().stream()
//                    .map(Role::getName).filter(Objects::nonNull).collect(Collectors.toList()));
//
//        } catch (AuthenticationException e) {
//            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
//        }
//    }
//
//    @Override
//    public boolean logout(String token) {
//        jwtTokenRepository.delete(new JwtToken(token));
//        return true;
//    }
//
//    @Override
//    public Boolean isValidToken(String token) {
//        return jwtTokenProvider.validateToken(token);
//    }
//
//    @Override
//    public String createNewToken(String token) {
//        String username = jwtTokenProvider.getUsername(token);
//        List<String>roleList = jwtTokenProvider.getRoleList(token);
//        String newToken =  jwtTokenProvider.createToken(username,roleList);
//        return newToken;
//    }
//}
