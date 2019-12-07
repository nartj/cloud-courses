package com.utbm.lo54.adminwebapp.service.impl;

import com.utbm.lo54.adminwebapp.repository.ClientRepository;
import com.utbm.lo54.adminwebapp.service.ClientService;
import com.utbm.lo54.core.domain.Client;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import com.utbm.lo54.security.domain.User;
import com.utbm.lo54.security.repository.UserRepository;
import com.utbm.lo54.security.service.impl.SecurityServiceImpl;
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
        User clientUser = userRepository.findByUsername(username);
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
