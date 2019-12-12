//package com.utbm.lo54.webapp.repository.impl;
//
//import com.utbm.lo54.webapp.repository.SecurityRepository;
//import com.utbm.lo54.webapp.utils.SecurityApiEndpoint;
//import org.json.JSONObject;
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
//public class SecurityRepositoryImpl implements SecurityRepository {
//
//    @Value("${application.gateway.url}")
//    private String baseUrl;
//
//    public String findLoggedInUsername() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity =
//                restTemplate.exchange(baseUrl
//                                + new SecurityApiEndpoint(SecurityType.UAA, Endpoint.CURRENT, Optional.empty()).getUri(),
//                        HttpMethod.GET, null, String.class);
//        return responseEntity.getBody();
//    }
//
//    public void autoLogin(String username, String password) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject json = new JSONObject();
//        json.put("username", username);
//        json.put("password", password);
//        HttpEntity<String> request =
//                new HttpEntity<>(json.toString(), headers);
//        ResponseEntity<String> responseEntity =
//                restTemplate.exchange(baseUrl
//                                + new SecurityApiEndpoint(SecurityType.UAA, Endpoint.AUTOLOG, Optional.empty()).getUri(),
//                        HttpMethod.POST, request, String.class);
//    }
//}
