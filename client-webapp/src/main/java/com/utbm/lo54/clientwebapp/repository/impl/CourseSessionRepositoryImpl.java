package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.CourseSessionRepository;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.ServiceApiEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseSessionRepositoryImpl implements CourseSessionRepository {
    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionRepositoryImpl.class);

    @Value("${application.gateway.url}")
    private String baseUrl;

    @Override
    public List<CourseSession> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Sending request to {}", baseUrl + "/api/course-session" + ServiceApiEndpoint.LIST.getEndpoint());
        ResponseEntity<List<CourseSession>> responseEntity =
                restTemplate.exchange(baseUrl + "/api/course-session" + ServiceApiEndpoint.LIST.getEndpoint(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseSession>>() {});
        return responseEntity.getBody();
    }

    @Override
    public Optional<CourseSession> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CourseSession> responseEntity =
                restTemplate.exchange(baseUrl + "/api/course-session" + ServiceApiEndpoint.FIND.getEndpoint() + id,
                        HttpMethod.GET, null, CourseSession.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    @Override
    public CourseSession save(CourseSession entity) {
        LOG.info("CourseSession to save : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CourseSession> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<CourseSession> client = restTemplate.exchange(baseUrl + "/api/course-session" + ServiceApiEndpoint.SAVE.getEndpoint(),
                HttpMethod.POST, request, CourseSession.class);
        return client.getBody();
    }

    @Override
    public CourseSession update(CourseSession entity) {
        LOG.info("CourseSession to update : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CourseSession> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<CourseSession> client = restTemplate.exchange(baseUrl + "/api/course-session" + ServiceApiEndpoint.UPDATE.getEndpoint() + entity.getId(),
                HttpMethod.PUT, request, CourseSession.class);
        return client.getBody();
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(baseUrl + "/api/course-session" + ServiceApiEndpoint.DELETE.getEndpoint() + id,
                HttpMethod.DELETE, null, Long.class);
    }
}
