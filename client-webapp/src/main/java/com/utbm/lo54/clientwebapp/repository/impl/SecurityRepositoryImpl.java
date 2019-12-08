package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.SecurityRepository;
import com.utbm.lo54.common.ServiceApiEndpoint;
import com.utbm.lo54.common.domain.courses.CourseSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class SecurityRepositoryImpl implements SecurityRepository {

    @Value("${application.gateway.url}")
    private String baseUrl;

    public String findLoggedInUsername() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(baseUrl + "security/current-user",
                        HttpMethod.GET, null, String.class);
        return responseEntity.getBody();
    }

    public void autoLogin(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        HttpEntity<String> request =
                new HttpEntity<>(json.toString(), headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(baseUrl + "security/current-user/autolog",
                        HttpMethod.POST, request, String.class);
    }
}
