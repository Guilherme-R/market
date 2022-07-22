package com.guilhermebrandao.response;

import com.guilhermebrandao.domain.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderSummaryResponse {

    private Long id;
    private LocalDateTime moment;
    private OrderStatus orderStatus;

    public OrderSummaryResponse() {
    }

    public OrderSummaryResponse(Long id, LocalDateTime moment, OrderStatus orderStatus) {
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
}
