package com.guilhermebrandao.domain;

import com.guilhermebrandao.domain.enums.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;

    private Customer customer;

    public Order() {
    }

    public Order(Long id, LocalDateTime moment, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
