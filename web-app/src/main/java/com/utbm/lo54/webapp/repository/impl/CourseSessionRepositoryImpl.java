//package com.utbm.lo54.cloudcourseswebapp.repository.impl;
//
//import com.utbm.lo54.cloudcourseswebapp.dto.CourseSessionDto;
//import com.utbm.lo54.cloudcourseswebapp.repository.CourseSessionRepository;
//import com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint.ServiceType;
//import static com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint.Endpoint;
//
//
//@Component
//public class CourseSessionRepositoryImpl implements CourseSessionRepository {
//    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionRepositoryImpl.class);
//
//    @Value("${application.gateway.url}")
//    private String baseUrl;
//
//    @Override
//    public List<CourseSessionDto> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to {}", baseUrl +
//                new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.ALL, Optional.empty()).getUri());
//        ResponseEntity<List<CourseSessionDto>> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.ALL, Optional.empty()).getUri(),
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseSessionDto>>() {});
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public Optional<CourseSessionDto> findById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<CourseSessionDto> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.FIND, Optional.of(id)).getUri(),
//                        HttpMethod.GET, null, CourseSessionDto.class);
//        return Optional.ofNullable(responseEntity.getBody());
//    }
//
//    @Override
//    public CourseSessionDto save(CourseSessionDto entity) {
//        LOG.info("CourseSessionDto to save : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<CourseSessionDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<CourseSessionDto> client = restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.SAVE, Optional.empty()).getUri(),
//                HttpMethod.POST, request, CourseSessionDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public CourseSessionDto update(CourseSessionDto entity) {
//        LOG.info("CourseSessionDto to update : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<CourseSessionDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<CourseSessionDto> client = restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.UPDATE, Optional.of(entity.getId())).getUri(),
//                HttpMethod.PUT, request, CourseSessionDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.COURSE_SESSION, Endpoint.DELETE, Optional.of(id)).getUri(),
//                HttpMethod.DELETE, null, Long.class);
//    }
//}
