package com.guilhermebrandao.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Client implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    private Set<Order> orders = new HashSet<>();

    public Client() {
    }

    public Client(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getCategories() {
        return orders;
    }

    public void addCategories(Order ...orders) {
        getCategories().addAll(Arrays.asList(orders));
    }

}
