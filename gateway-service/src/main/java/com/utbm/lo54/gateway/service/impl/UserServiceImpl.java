//package com.utbm.lo54.zuul.service.impl;
//
//import com.utbm.lo54.common.domain.security.User;
//import com.utbm.lo54.zuul.repository.RoleRepository;
//import com.utbm.lo54.zuul.repository.UserRepository;
//import com.utbm.lo54.zuul.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.HashSet;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public User save(User user) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findById(2L).get())));
//        user.setEnabled(true);
//        userRepository.save(user);
//        return user;
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
