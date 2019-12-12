//package com.utbm.lo54.cloudcourseswebapp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CustomFilter implements Filter {
//
//    private final Logger LOG = LoggerFactory.getLogger(CustomFilter.class);
//
//    @Override
//    public void doFilter(
//            ServletRequest request,
//            ServletResponse response,
//            FilterChain chain) throws IOException, ServletException {
//        LOG.info("Filtering request after authentication {}", request.toString());
//        BearerTokenExtractor extractor = new BearerTokenExtractor();
//        Authentication auth = extractor.extract((HttpServletRequest)request);
//        LOG.info("Filtered Bearer Token {}", auth.getPrincipal().toString());
//        ((HttpServletResponse)response).addHeader("Authorization: ", "Bearer " + auth.getPrincipal().toString());
//        chain.doFilter(request, response);
//    }
//}
