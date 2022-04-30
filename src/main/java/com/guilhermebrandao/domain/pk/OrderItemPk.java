package com.guilhermebrandao.domain.pk;

import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.domain.Product;

public class OrderItemPk {

    private Product product;
    private Order order;

    public OrderItemPk(){
    }

    public OrderItemPk(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
