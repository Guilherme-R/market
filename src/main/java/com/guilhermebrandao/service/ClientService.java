package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.client.ClientDaoImpl;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.dto.client.ClientUpdatePasswordDTO;
import com.guilhermebrandao.infra.security.PasswordValidator;
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
        PasswordValidator.validateClientPassword(client.getPassword());
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

    public void updatePassword(ClientUpdatePasswordDTO clientUpdatePasswordDto) {
        PasswordValidator.validateNewClientPassword(clientUpdatePasswordDto);
        clientDaoImpl.updatePassword(clientUpdatePasswordDto);
    }

}
