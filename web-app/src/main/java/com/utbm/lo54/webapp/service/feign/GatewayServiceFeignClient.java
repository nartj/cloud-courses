package com.utbm.lo54.webapp.service.feign;

import com.utbm.lo54.webapp.dto.UserCredentialsDto;
import com.utbm.lo54.webapp.dto.UserDto;
import feign.Response;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.security.Principal;
import java.util.Map;

@FeignClient(name = "gateway-service"/*, configuration = {GatewayServiceFeignClient.Configuration.class}*/)
public interface GatewayServiceFeignClient  {

    @PostMapping(value = "/oauth/token", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Response login(@RequestBody Map<String, String> form);

    @PostMapping(value = "/authenticate")
    Response authenticate();

//    class Configuration {
//
//        @Bean
//        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
//            return new SpringFormEncoder(new SpringEncoder(converters));
//        }
//    }
}
