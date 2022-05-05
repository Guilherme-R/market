package com.guilhermebrandao.response;

import com.guilhermebrandao.domain.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderResponse {

    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;

    private ClientResponse client;

    public OrderResponse() {
    }

    public OrderResponse(Long id, LocalDateTime moment, OrderStatus orderStatus, ClientResponse client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
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

    public ClientResponse getClient() {
        return client;
    }

    public void setClient(ClientResponse client) {
        this.client = client;
    }
}
