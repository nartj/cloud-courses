package com.utbm.lo54.clientwebapp.service.impl;

import com.utbm.lo54.clientwebapp.repository.ClientRepository;
import com.utbm.lo54.clientwebapp.repository.UserRepository;
import com.utbm.lo54.clientwebapp.repository.HttpRepository;
import com.utbm.lo54.clientwebapp.service.ClientService;
import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.domain.security.User;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    final static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityServiceImpl securityService;

    @Override
    public Client getClient(Long id) throws ResourceNotFoundException {

        logger.debug("Getting client with id " + id);
        return clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client newClient) {

        // Get current session User
        String username = securityService.findLoggedInUsername();
        logger.info("Current username (spring security) {} requested a client registration", username);
        User clientUser = userRepository.findByUserName(username);
        logger.info("Current user {} requested a client registration", clientUser);

        // Populate Client User
        newClient.setUserId(clientUser.getId());

        Client client = clientRepository.save(newClient);
        logger.debug("New Client save " + client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
