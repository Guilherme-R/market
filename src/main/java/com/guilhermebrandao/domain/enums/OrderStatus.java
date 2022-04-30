package com.guilhermebrandao.domain.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private Integer id;

    OrderStatus(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public static  OrderStatus valueOf(Integer id){
        for(OrderStatus order: OrderStatus.values()){
            if(order.getId().equals(id)){
                return order;
            };
        }
        throw new IllegalArgumentException("Id OrderStatus Inválido");
    }

}
