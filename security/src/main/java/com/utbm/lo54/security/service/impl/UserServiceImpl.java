package com.utbm.lo54.security.service.impl;

import com.utbm.lo54.security.domain.Authorities;
import com.utbm.lo54.security.domain.User;
import com.utbm.lo54.security.repository.UserRepository;
import com.utbm.lo54.security.service.CustomUserDetailsService;
import com.utbm.lo54.security.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CustomUserDetailsService customUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public User create(User user) {
        throwIfUsernameExists(user.getUsername());

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setActivated(Boolean.TRUE); // TODO send sms or email with code for activation
        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return (User)customUserDetailsService.loadUserByUsername(username);
    }

    private void throwIfUsernameExists(String username) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        existingUser.ifPresent((user) -> {
            throw new IllegalArgumentException("User not available");
        });
    }

}
