package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.client.ClientDaoImpl;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.dto.client.ClientUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDaoImpl clientDaoImpl;

    @Autowired
    public ClientService(ClientDaoImpl clientDaoImpl){
        this.clientDaoImpl = clientDaoImpl;
    }

    public List<Client> findAll() {
        return clientDaoImpl.findAll();
    }

    public Client findById(Long id) {
        return (Client) clientDaoImpl.findById(id).get();
    }

    public void insert(Client client) {
        clientDaoImpl.insert(client);
    }

    public void update(Client client) {
        findById(client.getId());
        clientDaoImpl.update(client);
    }

    public void delete(Long id) {
        findById(id);
        clientDaoImpl.delete(id);
    }

    public void updatePassword(ClientUpdateDTO clientUpdateDto) {
        Client client = findById(clientUpdateDto.getId());
        if (clientUpdateDto.getOldPassword() == client.getPassword()) {
            clientDaoImpl.updatePassword(clientUpdateDto.getNewPassword());
        } else {
            //TODO Criar Exceção personalizada
            throw new RuntimeException("");
        }
    }
}
