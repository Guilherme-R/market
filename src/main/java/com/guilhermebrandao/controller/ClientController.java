package com.guilhermebrandao.controller;

import com.guilhermebrandao.request.ClientGetRequestBody;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
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
    public ResponseEntity<List<ClientGetRequestBody>> findAll(){
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientGetRequestBody> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<Void> insert(@RequestBody ClientPostRequestBody clientPostRequestBody){
        clientService.insert(clientPostRequestBody);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/")
    public ResponseEntity<Void> update(@RequestBody ClientPutRequestBody clientPutRequestBody) {
        clientService.update(clientPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/password")
    public ResponseEntity<Void> updatePassword(@RequestBody ClientPutRequestBody clientPutRequestBody) {
        clientService.updatePassword(clientPutRequestBody);
        return ResponseEntity.noContent().build();
    }
}
