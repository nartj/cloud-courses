package com.utbm.lo54.servicelayer.controller;

import com.utbm.lo54.common.domain.courses.Client;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/client")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> listClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findClient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getClient(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        LOG.info("Saving client {}", client);
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        LOG.info("Saving client {}", client);
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public ResponseEntity<Long> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok(id);
    }
}
