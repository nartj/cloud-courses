package com.utbm.lo54.clientwebapp.repository.impl;

import com.utbm.lo54.clientwebapp.repository.ClientRepository;
import com.utbm.lo54.common.domain.courses.Client;
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
public class ClientRepositoryImpl implements ClientRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ClientRepositoryImpl.class);

    @Value("${application.gateway.url}")
    private String baseUrl;

    @Override
    public List<Client> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Sending request to {}", baseUrl + "/client-service/api/client" + ServiceApiEndpoint.LIST.getEndpoint());
        ResponseEntity<List<Client>> responseEntity =
                restTemplate.exchange(baseUrl + "/client-service/api/client" + ServiceApiEndpoint.LIST.getEndpoint(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {});
        return responseEntity.getBody();
    }

    @Override
    public Optional<Client> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> responseEntity =
                restTemplate.exchange(baseUrl + "/client-service/api/client" + ServiceApiEndpoint.FIND.getEndpoint() + id,
                        HttpMethod.GET, null, Client.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    @Override
    public Client save(Client entity) {
        LOG.info("Client to save : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Client> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Client> client = restTemplate.exchange(baseUrl + "/client-service/api/client" + ServiceApiEndpoint.SAVE.getEndpoint(),
                HttpMethod.POST, request, Client.class);
        return client.getBody();
    }

    @Override
    public Client update(Client entity) {
        LOG.info("Client to update : {}", entity);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Client> request =
                new HttpEntity<>(entity, headers);
        ResponseEntity<Client> client = restTemplate.exchange(baseUrl + "/client-service/api/client" + ServiceApiEndpoint.UPDATE.getEndpoint() + entity.getId(),
                HttpMethod.PUT, request, Client.class);
        return client.getBody();
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(baseUrl + "/client-service/api/client" + ServiceApiEndpoint.DELETE.getEndpoint() + id,
                HttpMethod.DELETE, null, Long.class);
    }
}
