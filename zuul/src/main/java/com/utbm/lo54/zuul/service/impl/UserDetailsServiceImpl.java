//package com.utbm.lo54.zuul.service.impl;
//
//import com.utbm.lo54.common.domain.security.Role;
//import com.utbm.lo54.common.domain.security.User;
//import com.utbm.lo54.zuul.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Transactional(readOnly=true)
//    @Override
//    public UserDetails loadUserByUsername(final String username)
//            throws UsernameNotFoundException {
//
//        User user = userRepository.findByUsername(username);
//        List<GrantedAuthority> authorities =
//                buildUserAuthority(user.getRoles());
//
//        return buildUserForAuthentication(user, authorities);
//
//    }
//
//    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
//                                                                                          List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                authorities);
//    }
//
//    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        // Build user's authorities
//        for (Role userRole : userRoles) {
//            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
//        }
//
//        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return result;
//    }
//
//}
