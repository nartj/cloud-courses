//package com.utbm.lo54.core;
//
//import com.utbm.lo54.core.users.domain.Authority;
//import com.utbm.lo54.core.users.domain.Role;
//import com.utbm.lo54.core.users.domain.User;
//import com.utbm.lo54.core.users.repository.AuthorityRepository;
//import com.utbm.lo54.core.users.repository.RoleRepository;
//import com.utbm.lo54.core.users.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
//@Component
//public class InitialDataLoader implements
//        ApplicationListener<ContextRefreshedEvent> {
//
//    private boolean alreadySetup = false;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private AuthorityRepository authorityRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if (alreadySetup)
//            return;
//        Authority readAuthority
//                = createAuthorityIfNotFound("READ_AUTHORITY");
//        Authority writeAuthority
//                = createAuthorityIfNotFound("WRITE_AUTHORITY");
//
//        List<Authority> adminAuthorities = Arrays.asList(
//                readAuthority, writeAuthority);
//        createRoleIfNotFound("ROLE_ADMIN", adminAuthorities);
//        createRoleIfNotFound("ROLE_USER", Arrays.asList(readAuthority));
//
//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//        User user = new User();
//        user.setUsername("master");
//        user.setPassword(passwordEncoder.encode("master"));
//        user.setRoles(new HashSet<>(Collections.singletonList(adminRole)));
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        alreadySetup = true;
//    }
//
//    @Transactional
//    Authority createAuthorityIfNotFound(String name) {
//
//        Optional<Authority> authority = authorityRepository.findByName(name);
//        if (!authority.isPresent()) {
//            Authority auth = new Authority(name);
//            authorityRepository.save(auth);
//            return auth;
//        }
//        return authority.get();
//    }
//
//    @Transactional
//    Role createRoleIfNotFound(
//            String name, Collection<Authority> authorities) {
//
//        Role role = roleRepository.findByName(name);
//        if (role == null) {
//            role = new Role(name);
//            role.setAuthorities(authorities);
//            roleRepository.save(role);
//        }
//        return role;
//    }
//}
