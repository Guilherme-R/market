package com.guilhermebrandao.request;

import com.guilhermebrandao.domain.Order;

import java.util.HashSet;
import java.util.Set;

public class ClientGetRequestBody {

    private Long id;
    private String name;
    private String email;
    private String phone;

    private Set<Order> orders = new HashSet<>();

    public ClientGetRequestBody() {
    }

    public ClientGetRequestBody(Long id, String name, String email, String phone, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
