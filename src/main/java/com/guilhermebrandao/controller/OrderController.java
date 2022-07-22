package com.guilhermebrandao.controller;

import com.guilhermebrandao.response.OrderResponse;
import com.guilhermebrandao.response.OrderSummaryResponse;
import com.guilhermebrandao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<OrderSummaryResponse>> findAllByClientId(){
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<OrderResponse>> findAllByClientId(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findAllByClientId(id));
    }
}
