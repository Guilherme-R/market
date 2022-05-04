package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.client.ClientDaoImpl;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.infra.security.PasswordValidator;
import com.guilhermebrandao.mapper.ClientMapper;
import com.guilhermebrandao.request.ClientGetRequestBody;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientDaoImpl clientDaoImpl;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientDaoImpl clientDaoImpl, ClientMapper clientMapper){
        this.clientDaoImpl = clientDaoImpl;
        this.clientMapper = clientMapper;
    }

    public List<ClientGetRequestBody> findAll() {
        return clientDaoImpl.findAll().stream().map(client ->
                clientMapper.toClientGetRequestBody(client)).collect(Collectors.toList());
    }

    public ClientGetRequestBody findById(Long id) {
        Client client = (Client) clientDaoImpl.findById(id).get();
        return clientMapper.toClientGetRequestBody(client);
    }

    public void insert(ClientPostRequestBody clientPostRequestBody) {
        Client client = clientMapper.toClient(clientPostRequestBody);
        PasswordValidator.validateClientPassword(client.getPassword());
        clientDaoImpl.insert(client);
    }

    public void update(ClientPutRequestBody clientPutRequestBody) {
        Client client = clientMapper.toClient(clientPutRequestBody);
        clientDaoImpl.findById(client.getId());
        clientDaoImpl.update(client);
    }

    public void delete(Long id) {
        clientDaoImpl.findById(id);
        clientDaoImpl.delete(id);
    }

    public void updatePassword(ClientPutRequestBody clientPutRequestBody) {
        PasswordValidator.validateNewClientPassword(clientPutRequestBody);
        clientDaoImpl.updatePassword(clientPutRequestBody);
    }
}
