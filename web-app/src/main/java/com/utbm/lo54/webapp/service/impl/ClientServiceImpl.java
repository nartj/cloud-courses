package com.utbm.lo54.webapp.service.impl;

import com.utbm.lo54.webapp.dto.ClientDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.ClientService;
import com.utbm.lo54.webapp.service.feign.ServiceLayerFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    final static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ServiceLayerFeignClient serviceLayerFeignClient;

    public ClientServiceImpl(ServiceLayerFeignClient serviceLayerFeignClient) {
        this.serviceLayerFeignClient = serviceLayerFeignClient;
    }

    @Override
    public ClientDto getClient(Long id) throws ResourceNotFoundException {

        logger.debug("Getting client with id " + id);
        return serviceLayerFeignClient.findClient(id)/*.orElseThrow(
                () -> new ResourceNotFoundException(id))*/;
    }

    @Override
    public List<ClientDto> getClients() {
        return serviceLayerFeignClient.findAllClients();
    }

    @Override
    public void save(ClientDto newClient, Long id) {
        ClientDto client = serviceLayerFeignClient.saveClient(newClient, id);
        logger.debug("New Client save " + client);
    }

    @Override
    public void deleteClient(Long id) {
        serviceLayerFeignClient.deleteClient(id);
    }
}
