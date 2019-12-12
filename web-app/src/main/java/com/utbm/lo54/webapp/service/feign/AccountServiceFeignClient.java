//package com.utbm.lo54.cloudcourseswebapp.service.feign;
//
//import com.utbm.lo54.cloudcourseswebapp.domain.TokenInfo;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserCredentialsDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserLoginDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserRegistrationDto;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.Map;
//
//@RestController
//@FeignClient(name = "account-service")
//@RibbonClient(name = "account-service")
//public interface AccountServiceFeignClient {
//
//    @PostMapping(value = "/accounts/user/")
//    UserDto createUser(@RequestBody UserCredentialsDto user);
//
//    @GetMapping(value = "/accounts/user/{username}")
//    UserDto findByUsername(@PathVariable String username);
//
//    @GetMapping(value = "/accounts/user/current")
//    UserDto findCurrentUser();
//
//    @PostMapping(value = "/accounts/user/login")
//    TokenInfo login(@RequestBody Map<String, String> user);
//}
