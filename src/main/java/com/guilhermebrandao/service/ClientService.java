package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.ClientDAO;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientDAO clientDao;

    @Autowired
    public ClientService(ClientDAO clientDao){
        this.clientDao = clientDao;
    }


    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findById(Long id) {
        Optional optional = clientDao.findById(id);
        return (Client) optional.get();
    }
}
