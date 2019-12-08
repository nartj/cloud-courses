package com.utbm.lo54.security;

import com.utbm.lo54.common.domain.security.Role;
import com.utbm.lo54.common.domain.security.User;
import com.utbm.lo54.security.repository.RoleRepository;
import com.utbm.lo54.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
@EntityScan("com.utbm.lo54.common.domain.security")
@EnableJpaRepositories("com.utbm.lo54.security.repository")
public class SecurityApp implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("ROLE_ADMIN"));
        roleRepository.save(new Role("ROLE_USER"));
        userService.save(new User("admin", passwordEncoder.encode("admin"), true, "admin", new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_ADMIN"), roleRepository.findByName("ROLE_USER")))));
        userService.save(new User("user", passwordEncoder.encode("user"), true, "user", new HashSet<>(Collections.singletonList(roleRepository.findByName("ROLE_USER")))));

    }
}
