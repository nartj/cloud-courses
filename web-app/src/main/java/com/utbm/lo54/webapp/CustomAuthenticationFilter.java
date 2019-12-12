//package com.utbm.lo54.cloudcourseswebapp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.web.util.NestedServletException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.text.MessageFormat;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//    private final Logger LOG = LoggerFactory.getLogger(CustomAuthenticationFilter.class);
//    private static final String SECURITY_TOKEN_KEY    = "access-token";
//    private static final String SECURITY_TOKEN_HEADER = "X-Token";
//    private String token = null;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    protected CustomAuthenticationFilter() {
//        super("/");
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        LOG.info("custom authentication filter Request : {}", req);
//        this.token = request.getParameter(SECURITY_TOKEN_KEY);
//        // or this.token = request.getHeader(SECURITY_TOKEN_HEADER);
//
////        if (request.getAttribute(FILTER_APPLIED) != null) {
////            chain.doFilter(request, response);
////            return;
////        }
////
////        request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
////
////        if(request.getParameter(actionParameter) !=null &&
////                request.getParameter(actionParameter).equals("logout")) {
////            SecurityContextHolder.clearContext();
////            return;
////        }
//
//        if (!requiresAuthentication(request, response)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        Authentication authResult;
//        try {
//            authResult = attemptAuthentication(request, response);
//            if (authResult == null) {
//                return;
//            }
//        } catch (AuthenticationException failed) {
//            unsuccessfulAuthentication(request, response, failed);
//            return;
//        }
//
//        try {
//            successfulAuthentication(request, response, chain, authResult);
//        } catch (NestedServletException e) {
//            if(e.getCause() instanceof AccessDeniedException) {
//                unsuccessfulAuthentication(request, response, new LockedException("Forbidden"));
//            }
//        }
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//
//        AbstractAuthenticationToken userAuthenticationToken = authUserByToken(this.token);
//        if(userAuthenticationToken == null)
//            throw new AuthenticationServiceException(MessageFormat.format("Error | {0}", "Bad Token"));
//
//        return userAuthenticationToken;
//    }
//
//    private AbstractAuthenticationToken authUserByToken(String tokenRaw) {
//        AbstractAuthenticationToken authToken = null;
//        try {
//            // check your input token, identify the user
//            // if success create AbstractAuthenticationToken for user to return
//            // eg:
//            List<GrantedAuthority> userAuthorities = Collections.singletonList(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return "ROLE_USER";
//                }
//            });
//
//            authToken = new UsernamePasswordAuthenticationToken("randomuser", passwordEncoder.encode("1234"), userAuthorities);
//
//        } catch (Exception e) {
//            logger.error("Error during authUserByToken", e);
//        }
//        return authToken;
//    }
//
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            Authentication authResult) throws IOException, ServletException {
//        SecurityContextHolder.getContext().setAuthentication(authResult);
//
//        getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
//    }
//
//}
