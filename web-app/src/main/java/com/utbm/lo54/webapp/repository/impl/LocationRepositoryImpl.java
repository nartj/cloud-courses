//package com.utbm.lo54.cloudcourseswebapp.repository.impl;
//
//import com.utbm.lo54.cloudcourseswebapp.dto.LocationDto;
//import com.utbm.lo54.cloudcourseswebapp.repository.LocationRepository;
//import com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint.ServiceType;
//import static com.utbm.lo54.cloudcourseswebapp.utils.ServicesApiEndpoint.Endpoint;
//
//@Component
//public class LocationRepositoryImpl implements LocationRepository {
//    private static final Logger LOG = LoggerFactory.getLogger(LocationRepositoryImpl.class);
//
//    @Value("${application.gateway.url}")
//    private String baseUrl;
//
//    @Override
//    public List<LocationDto> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to {}", baseUrl +
//                new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.ALL, Optional.empty()).getUri());
//        ResponseEntity<List<LocationDto>> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.ALL, Optional.empty()).getUri(),
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<LocationDto>>() {});
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public Optional<LocationDto> findById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<LocationDto> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.FIND, Optional.of(id)).getUri(),
//                        HttpMethod.GET, null, LocationDto.class);
//        return Optional.ofNullable(responseEntity.getBody());
//    }
//
//    @Override
//    public LocationDto save(LocationDto entity) {
//        LOG.info("LocationDto to save : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<LocationDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<LocationDto> location = restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.SAVE, Optional.empty()).getUri(),
//                HttpMethod.POST, request, LocationDto.class);
//        return location.getBody();
//    }
//
//    @Override
//    public LocationDto update(LocationDto entity) {
//        LOG.info("LocationDto to update : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<LocationDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<LocationDto> location = restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.UPDATE, Optional.of(entity.getId())).getUri(),
//                HttpMethod.PUT, request, LocationDto.class);
//        return location.getBody();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.LOCATION, Endpoint.ALL, Optional.of(id)).getUri(),
//                HttpMethod.DELETE, null, Long.class);
//    }
//}
