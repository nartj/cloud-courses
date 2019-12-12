//package com.utbm.lo54.webapp.service.impl;
//
//import com.utbm.lo54.webapp.dto.UserDto;
//import com.utbm.lo54.webapp.repository.SecurityRepository;
//import com.utbm.lo54.webapp.service.SecurityService;
//import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityServiceImpl implements SecurityService {
//    final static Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
//    private final SecurityRepository securityRepository;
//    private final GatewayServiceFeignClient gatewayServiceFeignClient;
//
//    private SecurityServiceImpl(GatewayServiceFeignClient gatewayServiceFeignClient,
//                                SecurityRepository securityRepository) {
//        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
//        this.securityRepository = securityRepository;
//    }
//
//    public UserDto findLoggedInUsername() {
//        logger.debug("Getting logged in user");
//        return gatewayServiceFeignClient.findCurrentUser();
//    }
//
//    @Override
//    public void autoLogin(String username, String passwordConfirm) {
//        logger.debug("Auto logging {}", username);
//        securityRepository.autoLogin(username, passwordConfirm);
//    }
//}
