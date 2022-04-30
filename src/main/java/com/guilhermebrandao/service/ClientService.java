package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(ClientDao clientDao){
        this.clientDao = clientDao;
    }

    public List findAll() {
        return clientDao.findAll();
    }
}
