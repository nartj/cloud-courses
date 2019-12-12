//package com.utbm.lo54.webapp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.Map;
//
//@Component
//public class AuthenticationTokenFilter implements Filter {
//
//    private static final Logger logger = LoggerFactory.getLogger(AuthenticationTokenFilter.class);
//
//    @Override
//    public void init(FilterConfig fc) throws ServletException {
//        logger.info("Init AuthenticationTokenFilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
//        SecurityContext context = SecurityContextHolder.getContext();
//        if (context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
//            // do nothing
//        } else {
//            Map<String,String[]> params = req.getParameterMap();
//            if (!params.isEmpty() && params.containsKey("auth_token")) {
//                String token = params.get("auth_token")[0];
//                if (token != null) {
//                    Authentication auth = new TokenAuthentication(token);
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                }
//            }
//        }
//
//        fc.doFilter(req, res);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
