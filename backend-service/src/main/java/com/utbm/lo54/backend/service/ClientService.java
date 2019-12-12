package com.utbm.lo54.backend.service;

import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.List;

public interface ClientService {

    Client getClient(Long id) throws ResourceNotFoundException;

    List<Client> getClients();

    void save(Client client, Long courseSessionId) throws ResourceNotFoundException;

    void deleteClient(Long id);

    Integer findCourseSessionNbClients(Long id);
}
