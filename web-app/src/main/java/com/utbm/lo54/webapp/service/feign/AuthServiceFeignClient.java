//package com.utbm.lo54.cloudcourseswebapp.service.feign;
//
//import com.utbm.lo54.cloudcourseswebapp.dto.PrincipalDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserCredentialsDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserDto;
//import com.utbm.lo54.cloudcourseswebapp.dto.UserRegistrationDto;
//import feign.Response;
//import feign.codec.Encoder;
//import feign.form.spring.SpringFormEncoder;
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.openfeign.support.SpringEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@FeignClient(name = "auth-service", configuration = {AuthServiceFeignClient.Configuration.class})
//public interface AuthServiceFeignClient  {
//
//    @GetMapping(value = "/uaa/user")
//    UserDetails findByUsername(@RequestParam String username);
//
//    @GetMapping(value = "/uaa/user/current")
//    PrincipalDto findCurrentUser();
//
//    @PostMapping(value = "/uaa/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    Response login(@RequestBody Map<String, ?> form);
//
//    class Configuration {
//
//        @Bean
//        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
//            return new SpringFormEncoder(new SpringEncoder(converters));
//        }
//    }
//}
//
