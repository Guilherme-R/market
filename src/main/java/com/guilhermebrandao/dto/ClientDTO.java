package com.guilhermebrandao.dto;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.domain.Order;

import java.util.HashSet;
import java.util.Set;

public class ClientDTO {

    private Long idClient;
    private String name;
    private String email;
    private String phone;

    private Set<Order> orders = new HashSet<>();

    public ClientDTO(){
    }

    public ClientDTO(Client client){
        this.idClient = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.orders = client.getOrders();
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
