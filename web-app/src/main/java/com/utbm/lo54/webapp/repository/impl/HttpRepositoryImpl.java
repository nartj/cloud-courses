//package com.utbm.lo54.clientwebapp.repository.impl;
//
//import com.utbm.lo54.clientwebapp.repository.HttpRepository;
//import com.utbm.lo54.common.ServiceApiEndpoint;
//import com.utbm.lo54.common.domain.GenericWrapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class HttpRepositoryImpl<T extends GenericWrapper> implements HttpRepository<T> {
//    private static final Logger LOG = LoggerFactory.getLogger(HttpRepositoryImpl.class);
//
//    @Value("application.gateway.url")
//    private String baseUrl;
//
//    final Class<T> typeParameterClass;
//
//    public HttpRepositoryImpl(Class<T> typeParameterClass) {
//        this.typeParameterClass = typeParameterClass;
//    }
//
//    @Override
//    public List<T> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to {}", getServiceUrl() + ServiceApiEndpoint.LIST.getEndpoint());
//        ResponseEntity<List<T>> responseEntity =
//                restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.LIST.getEndpoint(),
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<T>>() {});
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public Optional<T> findById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<T> responseEntity =
//                restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.FIND.getEndpoint() + id,
//                        HttpMethod.GET, null, typeParameterClass);
//        return Optional.ofNullable(responseEntity.getBody());
//    }
//
//    @Override
//    public T save(T entity) {
//        LOG.info("Location to save : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<T> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<T> location = restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.SAVE.getEndpoint(),
//                HttpMethod.POST, request, typeParameterClass);
//        return location.getBody();
//    }
//
//    @Override
//    public T update(T entity) {
//        LOG.info("Location to update : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<T> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<T> location = restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.UPDATE.getEndpoint() + entity.getId(),
//                HttpMethod.PUT, request, typeParameterClass);
//        return location.getBody();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(getServiceUrl() + ServiceApiEndpoint.DELETE.getEndpoint() + id,
//                HttpMethod.DELETE, null, Long.class);
//    }
//
//    private String getServiceUrl() {
//        switch (typeParameterClass.getName()) {
//            case "Client":
//                return baseUrl + "client-service";
//            case "Course":
//                return baseUrl + "course-service";
//            case "CourseSession":
//                return baseUrl + "course-session-service";
//            case "Location":
//                return baseUrl + "location-service";
//            case "User":
//                return baseUrl + "user-service";
//            default:
//                throw new IllegalStateException("Unexpected value: " + typeParameterClass);
//        }
//    }
//}
