package com.utbm.lo54.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityApp /*implements CommandLineRunner */{

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        roleRepository.save(new Role("ROLE_ADMIN"));
//        roleRepository.save(new Role("ROLE_USER"));
//        userService.save(new User("admin", passwordEncoder.encode("admin"), true, "admin", new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_ADMIN"), roleRepository.findByName("ROLE_USER")))));
//        userService.save(new User("user", passwordEncoder.encode("user"), true, "user", new HashSet<>(Collections.singletonList(roleRepository.findByName("ROLE_USER")))));
//
//    }
}
