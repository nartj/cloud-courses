package com.utbm.lo54.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static List<User> users = new ArrayList();

    public CustomAuthenticationProvider() {
        users.add(new User("anonymous", "anonymous", Collections.singletonList("ROLE_USER")));
        users.add(new User("professor", "professor", Arrays.asList("ROLE_USER", "ROLE_PROFESSOR")));
        users.add(new User("admin", "admin", Collections.singletonList("ROLE_USER")));
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = (String)credentials;

        Optional<User> userOptional = users.stream()
                .filter(u -> u.match(name, password))
                .findFirst();

        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : userOptional.get().roles)
            grantedAuthorities.addAll(AuthorityUtils.createAuthorityList(role));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private static class User {
        private String name;
        private String password;
        private List<String> roles;

        public User(String name, String password, List<String> roles) {
            this.name = name;
            this.password = password;
            this.roles = roles;
        }

        public boolean match(String name, String password) {
            return this.name.equals(name) && this.password.equals(password);
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public User setPassword(String password) {
            this.password = password;
            return this;
        }

        public List<String> getRoles() {
            return roles;
        }

        public User setRoles(List<String> roles) {
            this.roles = roles;
            return this;
        }
    }
}
