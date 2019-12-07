package com.utbm.lo54.clientwebapp.controller;

import com.utbm.lo54.clientwebapp.service.ClientService;
import com.utbm.lo54.core.domain.Client;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String listClients(Model theModel) {
        List<Client> clients = clientService.getClients();
        theModel.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/showForm")
    public String createClient(Model theModel) {
        LOG.debug("inside show client creation form handler method");
        Client client = new Client();
        theModel.addAttribute("client", client);
        return "client-form";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/client/list";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateClient(@RequestParam("id") Long id,
                                    Model theModel) throws ResourceNotFoundException {
        Client client = clientService.getClient(id);
        theModel.addAttribute("client", client);
        return "client-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClient(id);
        return "redirect:/client/list";
    }
}
