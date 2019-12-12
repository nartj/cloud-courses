//package com.utbm.lo54.cloudcourseswebapp.repository.impl;
//
//import com.utbm.lo54.cloudcourseswebapp.dto.CourseDto;
//import com.utbm.lo54.cloudcourseswebapp.repository.CourseRepository;
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
//@Component
//public class CourseRepositoryImpl implements CourseRepository {
//    private static final Logger LOG = LoggerFactory.getLogger(CourseRepositoryImpl.class);
//
//    @Value("${application.gateway.url}")
//    private String baseUrl;
//
//    @Override
//    public List<CourseDto> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to {}", baseUrl
//                + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.ALL, Optional.empty()).getUri());
//        ResponseEntity<List<CourseDto>> responseEntity =
//                restTemplate.exchange(baseUrl
//                                + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.ALL, Optional.empty()).getUri(),
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseDto>>() {});
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public Optional<CourseDto> findById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<CourseDto> responseEntity =
//                restTemplate.exchange(baseUrl
//                                + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.FIND, Optional.of(id)).getUri(),
//                        HttpMethod.GET, null, CourseDto.class);
//        return Optional.ofNullable(responseEntity.getBody());
//    }
//
//    @Override
//    public CourseDto save(CourseDto entity) {
//        LOG.info("CourseDto to save : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<CourseDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<CourseDto> client = restTemplate.exchange(baseUrl
//                        + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.SAVE, Optional.empty()).getUri(),
//                HttpMethod.POST, request, CourseDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public CourseDto update(CourseDto entity) {
//        LOG.info("CourseDto to update : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<CourseDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<CourseDto> client = restTemplate.exchange(baseUrl
//                        + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.UPDATE, Optional.of(entity.getId())).getUri(),
//                HttpMethod.PUT, request, CourseDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(baseUrl
//                        + new ServicesApiEndpoint(ServiceType.COURSE, Endpoint.DELETE, Optional.of(id)).getUri(),
//                HttpMethod.DELETE, null, Long.class);
//    }
//}
