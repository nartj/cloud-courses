package com.utbm.lo54.clientwebapp.service;


import com.utbm.lo54.core.courses.domain.Client;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ClientService {
    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    Client getClient(Long id) throws ResourceNotFoundException;

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    List<Client> getClients();

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    void save(Client client);

    @Secured({"ROLE_ADMIN"})
    void deleteClient(Long id);
}
