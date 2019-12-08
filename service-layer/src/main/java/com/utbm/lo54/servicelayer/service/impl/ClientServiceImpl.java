package com.utbm.lo54.servicelayer.service.impl;

import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.repository.ClientRepository;
import com.utbm.lo54.servicelayer.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    final static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClient(Long id) throws ResourceNotFoundException {
        logger.info("Getting client with id " + id);
        return clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client newClient) {
        Client client = clientRepository.save(newClient);
        logger.info("New Client save " + client);
    }

    @Override
    public void deleteClient(Long id) {
        logger.info("Deleting client with id " + id);
        clientRepository.deleteById(id);
    }
}
