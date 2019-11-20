package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.CourseRepository;
import com.utbm.lo54.core.courses.domain.Course;
import com.utbm.lo54.core.courses.utils.ServiceApiEndpoint;
import com.utbm.lo54.core.users.service.impl.SecurityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRepositoryImpl.class);

    @Value("${services.course.url}")
    private String courseServiceUrl;

    @Override
    public String getServiceUrl() {
        return courseServiceUrl;
    }

    @Override
    public List<Course> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Sending request to {}", getServiceUrl() + ServiceApiEndpoint.LIST.getEndpoint());
        ResponseEntity<List<Course>> responseEntity =
                restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.LIST.getEndpoint(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Course>>() {});
        return responseEntity.getBody();
    }

    @Override
    public Optional<Course> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Course> responseEntity =
                restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.FIND.getEndpoint() + id,
                        HttpMethod.GET, null, Course.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    @Override
    public Course save(Course entity) {
        LOG.info("Course to save : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Course> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Course> client = restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.SAVE.getEndpoint(),
                HttpMethod.POST, request, Course.class);
        return client.getBody();
    }

    @Override
    public Course update(Course entity) {
        LOG.info("Course to update : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Course> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Course> client = restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.UPDATE.getEndpoint() + entity.getId(),
                HttpMethod.PUT, request, Course.class);
        return client.getBody();
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.DELETE.getEndpoint() + id,
                HttpMethod.DELETE, null, Long.class);
    }
}
