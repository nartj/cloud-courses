//package com.utbm.lo54.webapp.repository.impl;
//
//import com.utbm.lo54.webapp.dto.UserDto;
//import com.utbm.lo54.webapp.dto.UserRegistrationDto;
//import com.utbm.lo54.webapp.repository.UserRepository;
//import com.utbm.lo54.webapp.utils.SecurityApiEndpoint;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Optional;
//
//import static com.utbm.lo54.webapp.utils.SecurityApiEndpoint.SecurityType;
//import static com.utbm.lo54.webapp.utils.SecurityApiEndpoint.Endpoint;
//
//@Component
//public class UserRepositoryImpl implements UserRepository {
//    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);
//
//    @Override
//    public UserDto findByUserName(String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to security-service{}",
//                new SecurityApiEndpoint(SecurityType.ACCOUNT, Endpoint.FIND, Optional.of(username)).getUri());
//        ResponseEntity<UserDto> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new SecurityApiEndpoint(SecurityType.ACCOUNT, Endpoint.FIND, Optional.of(username))
//                                        .getUri(),
//                        HttpMethod.GET, null, UserDto.class);
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public UserDto save(UserRegistrationDto user) {
//        LOG.info("UserDto to save: {}", user);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<UserRegistrationDto> request =
//                new HttpEntity<>(user, headers);
//        ResponseEntity<UserDto> userResponse = restTemplate.exchange(baseUrl
//                        + new SecurityApiEndpoint(SecurityType.ACCOUNT, Endpoint.SAVE, Optional.empty()).getUri(),
//                HttpMethod.POST, request, UserDto.class);
//        return userResponse.getBody();
//    }
//
//}
