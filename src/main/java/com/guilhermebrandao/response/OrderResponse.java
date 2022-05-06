package com.guilhermebrandao.response;

import com.guilhermebrandao.domain.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderResponse {

    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;

    private CustomerResponse customer;

    public OrderResponse() {
    }

    public OrderResponse(Long id, LocalDateTime moment, OrderStatus orderStatus, CustomerResponse customer) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.customer = customer;
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

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }
}
