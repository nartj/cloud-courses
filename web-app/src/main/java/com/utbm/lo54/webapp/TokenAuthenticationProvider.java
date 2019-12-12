//package com.utbm.lo54.cloudcourseswebapp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TokenAuthenticationProvider implements AuthenticationProvider {
//
//    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationProvider.class);
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        if (auth.isAuthenticated())
//            return auth;
//
//        String token = auth.getCredentials().toString();
//        logger.info("Token authentication.getCredentials {}", token);
//        User user = null;//userDetailsService.auth(token);
//
//        if (user != null) {
//            auth = new PreAuthenticatedAuthenticationToken(user, token);
//            auth.setAuthenticated(true);
//            logger.debug("Token authentication. Token: ");
//        } else
//            throw new BadCredentialsException("Invalid token " + token);
//        return auth;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//
//}
