package com.guilhermebrandao.controller;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.dto.client.ClientDTO;
import com.guilhermebrandao.dto.client.ClientUpdateDTO;
import com.guilhermebrandao.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping(path = "/")
    public ResponseEntity<Void> insert(@RequestBody Client client){
        clientService.insert(client);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/")
    public ResponseEntity<Void> update(@RequestBody Client client) {
        clientService.update(client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //TODO Arrumar a URL
    @PutMapping(path = "/p")
    public ResponseEntity<Void> updatePassword(@RequestBody ClientUpdateDTO clientUpdateDto) {
        clientService.updatePassword(clientUpdateDto);
        return ResponseEntity.noContent().build();
    }
}
