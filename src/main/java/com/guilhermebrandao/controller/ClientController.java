package com.guilhermebrandao.controller;

import com.guilhermebrandao.dao.ClientDao;
import com.guilhermebrandao.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(path = "/")
    public List list(){
        return clientService.findAll();
    }
}
