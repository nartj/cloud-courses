package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.LocationRepository;
import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.ServiceApiEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepositoryImpl implements LocationRepository {
    private static final Logger LOG = LoggerFactory.getLogger(LocationRepositoryImpl.class);

    @Value("${application.gateway.url}")
    private String baseUrl;

    @Override
    public List<Location> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Sending request to {}", baseUrl + "/api/location" + ServiceApiEndpoint.LIST.getEndpoint());
        ResponseEntity<List<Location>> responseEntity =
                restTemplate.exchange(baseUrl + "/api/location" + ServiceApiEndpoint.LIST.getEndpoint(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Location>>() {});
        return responseEntity.getBody();
    }

    @Override
    public Optional<Location> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Location> responseEntity =
                restTemplate.exchange(baseUrl + "/api/location" + ServiceApiEndpoint.FIND.getEndpoint() + id,
                        HttpMethod.GET, null, Location.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    @Override
    public Location save(Location entity) {
        LOG.info("Location to save : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Location> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Location> location = restTemplate.exchange(baseUrl + "/api/location" + ServiceApiEndpoint.SAVE.getEndpoint(),
                HttpMethod.POST, request, Location.class);
        return location.getBody();
    }

    @Override
    public Location update(Location entity) {
        LOG.info("Location to update : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Location> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Location> location = restTemplate.exchange(baseUrl + "/api/location"+ ServiceApiEndpoint.UPDATE.getEndpoint() + entity.getId(),
                HttpMethod.PUT, request, Location.class);
        return location.getBody();
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(baseUrl + "/api/location" + ServiceApiEndpoint.DELETE.getEndpoint() + id,
                HttpMethod.DELETE, null, Long.class);
    }
}
