package com.guilhermebrandao.controller;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.dto.ClientDTO;
import com.guilhermebrandao.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> clientsDTO = clientService.findAll().stream().map(a -> new ClientDTO(a)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientsDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO clientDTO = new ClientDTO(clientService.findById(id));
        return ResponseEntity.ok().body(clientDTO);
    }
}
