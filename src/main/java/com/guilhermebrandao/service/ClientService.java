package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.client.ClientDaoImpl;
import com.guilhermebrandao.dao.order.OrderDaoImpl;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.infra.security.PasswordValidator;
import com.guilhermebrandao.mapper.ClientMapper;
import com.guilhermebrandao.response.ClientResponse;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientDaoImpl clientDaoImpl;
    private final OrderDaoImpl orderDaoImpl;

    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientDaoImpl clientDaoImpl, ClientMapper clientMapper, OrderDaoImpl orderDaoImpl){
        this.clientDaoImpl = clientDaoImpl;
        this.clientMapper = clientMapper;
        this.orderDaoImpl = orderDaoImpl;
    }

    public List<ClientResponse> findAll() {
        return clientDaoImpl.findAll().stream().map(client ->
                clientMapper.toClientResponse(client)).collect(Collectors.toList());
    }

    public ClientResponse findById(Long id) {
        Client client = (Client) clientDaoImpl.findById(id).get();
        client.addOrders(orderDaoImpl.findAllByClientId(id));
        return clientMapper.toClientResponse(client);
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
