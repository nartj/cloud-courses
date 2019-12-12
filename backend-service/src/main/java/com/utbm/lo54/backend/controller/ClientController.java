package com.utbm.lo54.backend.controller;

import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/clients")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getClient(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping("/course-session/{id}")
    public ResponseEntity<Client> createClient(@RequestBody Client client, @PathVariable("id") Long id) throws ResourceNotFoundException {
        LOG.info("Saving client {}", client);
        clientService.save(client, id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}/course-session/{courseSessionId}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable("id") Long id, @PathVariable("courseSessionId") Long courseSessionId) {
        LOG.info("Updating client {}", client);
        Client updatedClient = null;
        try {
            updatedClient = clientService.getClient(id);
            updatedClient
                    .setAddress(client.getAddress())
                    .setEmail(client.getEmail())
                    .setFirstName(client.getFirstName())
                    .setLastName(client.getLastName());
            clientService.save(updatedClient, courseSessionId);
            return ResponseEntity.ok(updatedClient);
        } catch (ResourceNotFoundException e) {
            return (ResponseEntity<Client>) ResponseEntity.notFound();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/course-session/{id}/filling")
    public ResponseEntity<Integer> findCourseSessionNbClients(@PathVariable Long id) {
        Integer nbClients = clientService.findCourseSessionNbClients(id);
        LOG.info("CourseSession {} has already {} clients.", id, nbClients);
        return ResponseEntity.ok(nbClients);
    }
}
