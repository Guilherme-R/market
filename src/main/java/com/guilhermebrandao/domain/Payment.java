package com.guilhermebrandao.domain;

import com.guilhermebrandao.domain.enums.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;
    private LocalDateTime moment;

    private Order order;

    public Payment() {
    }

    public Payment(Long id, LocalDateTime moment) {
        this.id = id;
        this.moment = moment;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
