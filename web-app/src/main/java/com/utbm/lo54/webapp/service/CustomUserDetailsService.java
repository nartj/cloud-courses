//package com.utbm.lo54.webapp.service;
//
//import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private GatewayServiceFeignClient gatewayServiceFeignClient;
//
//    public CustomUserDetailsService(GatewayServiceFeignClient gatewayServiceFeignClient) {
//        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (UserDetails)gatewayServiceFeignClient.findByUsername(username);
//    }
//
//}
