package com.utbm.lo54.backend.service.impl;

import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.repository.ClientRepository;
import com.utbm.lo54.backend.service.ClientService;
import com.utbm.lo54.backend.service.CourseSessionService;
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
    @Autowired
    private CourseSessionService courseSessionService;

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
    public void save(Client newClient, Long courseSessionId) throws ResourceNotFoundException {
        logger.info("New Client save {}", newClient);
        CourseSession courseSession = courseSessionService.getCourseSession(courseSessionId);
        newClient.setCourseSession(courseSession);
        logger.info("New Client save {}",clientRepository.save(newClient));
    }

    @Override
    public void deleteClient(Long id) {
        logger.info("Deleting client with id " + id);
        clientRepository.deleteById(id);
    }

    @Override
    public Integer findCourseSessionNbClients(Long id) {
        return clientRepository.countClientByCourseSessionId(id);
    }
}
