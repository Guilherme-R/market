package com.guilhermebrandao.controller;

import com.guilhermebrandao.response.ClientResponse;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
import com.guilhermebrandao.response.OrderResponse;
import com.guilhermebrandao.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ClientResponse>> findAll(){
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<ClientResponse> insert(@RequestBody ClientPostRequestBody clientPostRequestBody){
        ClientResponse clientResponse = clientService.insert(clientPostRequestBody);
        return ResponseEntity.ok().body(clientResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClientPutRequestBody clientPutRequestBody, @PathVariable Long id) {
        clientPutRequestBody.setId(id);
        clientService.update(clientPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}/new_password")
    public ResponseEntity<Void> updatePassword(@RequestBody ClientPutRequestBody clientPutRequestBody, @PathVariable Long id) {
        clientPutRequestBody.setId(id);
        clientService.updatePassword(clientPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
