//package com.utbm.lo54.cloudcourseswebapp;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Configuration
//public class AuthForwardInterceptor implements RequestInterceptor {
//    private final Logger log = LoggerFactory.getLogger(AuthForwardInterceptor.class);
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        log.info("AuthForwardInterceptor : RequestTemplate {}", requestTemplate);
//        if (requestAttributes == null) {
//            return;
//        }
//        HttpServletRequest request = requestAttributes.getRequest();
//        if (request == null) {
//            return;
//        }
//        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (auth == null) {
//            return;
//        }
//        log.info("AuthForwardInterceptor : added header {} to requestTemplate", request.getHeader(HttpHeaders.AUTHORIZATION));
//        requestTemplate.header(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
//    }
//}
