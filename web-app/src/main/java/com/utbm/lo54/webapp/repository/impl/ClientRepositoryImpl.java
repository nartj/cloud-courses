//package com.utbm.lo54.cloudcourseswebapp.repository.impl;
//
//import com.utbm.lo54.cloudcourseswebapp.dto.ClientDto;
//import com.utbm.lo54.cloudcourseswebapp.repository.ClientRepository;
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
//public class ClientRepositoryImpl implements ClientRepository {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ClientRepositoryImpl.class);
//
//    @Override
//    public List<ClientDto> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        LOG.info("Sending request to {}", baseUrl
//                + new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.ALL, Optional.empty()).getUri());
//        ResponseEntity<List<ClientDto>> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.ALL, Optional.empty()).getUri(),
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ClientDto>>() {});
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public Optional<ClientDto> findById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ClientDto> responseEntity =
//                restTemplate.exchange(baseUrl +
//                                new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.FIND, Optional.of(id)).getUri(),
//                        HttpMethod.GET, null, ClientDto.class);
//        return Optional.ofNullable(responseEntity.getBody());
//    }
//
//    @Override
//    public ClientDto save(ClientDto entity) {
//        LOG.info("ClientDto to save : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<ClientDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<ClientDto> client = restTemplate.exchange(baseUrl
//                        + new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.SAVE, Optional.empty()).getUri(),
//                HttpMethod.POST, request, ClientDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public ClientDto update(ClientDto entity) {
//        LOG.info("ClientDto to update : {}", entity);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<ClientDto> request =
//                new HttpEntity<>(entity, headers);
//        ResponseEntity<ClientDto> client = restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.UPDATE, Optional.of(entity.getId())).getUri(),
//                HttpMethod.PUT, request, ClientDto.class);
//        return client.getBody();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.exchange(baseUrl +
//                        new ServicesApiEndpoint(ServiceType.CLIENT, Endpoint.DELETE, Optional.of(id)).getUri(),
//                HttpMethod.DELETE, null, Long.class);
//    }
//}
