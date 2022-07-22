package com.guilhermebrandao.mapper;

import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.response.OrderResponse;
import com.guilhermebrandao.response.OrderSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderResponse orderResponse);
    OrderResponse toOrderResponse(Order order);

    OrderSummaryResponse toOrderSummaryResponse(Order order);
}
