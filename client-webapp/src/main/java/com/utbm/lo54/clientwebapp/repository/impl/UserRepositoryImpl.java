package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.UserRepository;
import com.utbm.lo54.common.ServiceApiEndpoint;
import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.domain.security.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Value("${application.gateway.url}")
    private String baseUrl;

    @Override
    public User findByUserName(String username) {
        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Sending request to security-service{}", ServiceApiEndpoint.FIND.getEndpoint() + username);
        ResponseEntity<User> responseEntity =
                restTemplate.exchange(baseUrl + "/security-service/user" + ServiceApiEndpoint.FIND.getEndpoint() + username,
                        HttpMethod.GET, null, User.class);
        return responseEntity.getBody();
    }

    @Override
    public User save(User user) {
        LOG.info("User to save: {}", user);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request =
                new HttpEntity<>(user, headers);
        ResponseEntity<User> userResponse = restTemplate.exchange(baseUrl + "/security-service/user" + ServiceApiEndpoint.SAVE.getEndpoint(),
                HttpMethod.POST, request, User.class);
        return userResponse.getBody();
    }

}
