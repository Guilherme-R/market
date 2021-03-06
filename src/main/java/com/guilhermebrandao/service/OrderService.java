package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.order.OrderDaoImpl;
import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.mapper.OrderMapper;
import com.guilhermebrandao.response.OrderResponse;
import com.guilhermebrandao.response.OrderSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderDaoImpl orderDaoImpl;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderDaoImpl orderDaoImpl, OrderMapper orderMapper){
        this.orderDaoImpl = orderDaoImpl;
        this.orderMapper = orderMapper;
    }

    public Order findById(Long id) {
        return new Order();
    }

    public List<OrderSummaryResponse> findAll() {
        return orderDaoImpl.findAll().stream().map(order -> orderMapper.toOrderSummaryResponse(order)).collect(Collectors.toList());
    }

    public List<OrderResponse> findAllByClientId(Long clientId){
        List<Order> orders = orderDaoImpl.findAllByCustomerId(clientId);
        return orders.stream().map(order -> orderMapper.toOrderResponse(order)).collect(Collectors.toList());
    }

    public OrderResponse insert() {
        return new OrderResponse();
    }

    public void update() {
    }

    public void delete(Long id) {
    }
}
