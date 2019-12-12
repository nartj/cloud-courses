package com.utbm.lo54.webapp.service;


import com.utbm.lo54.webapp.dto.ClientDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;

import java.util.List;

public interface ClientService {

    ClientDto getClient(Long id) throws ResourceNotFoundException;

    List<ClientDto> getClients();

    void save(ClientDto client, Long id);

    void deleteClient(Long id);
}
