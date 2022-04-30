package com.guilhermebrandao.domain;

import com.guilhermebrandao.domain.pk.OrderItemPk;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private OrderItemPk id;
    private Long quantity;
    private Double price;

    public OrderItem(){
    }

    public OrderItem(Order order, Product product, OrderItemPk id, Long quantity, Double price) {
        this.id.setProduct(product);
        this.id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemPk getId() {
        return id;
    }

    public void setId(OrderItemPk id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        this.id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        this.id.setProduct(product);
    }
}

