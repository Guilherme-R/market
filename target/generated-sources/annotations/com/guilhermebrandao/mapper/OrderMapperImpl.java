package com.guilhermebrandao.mapper;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.response.ClientResponse;
import com.guilhermebrandao.response.OrderResponse;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-05T12:32:33-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderResponse orderResponse) {
        if ( orderResponse == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderResponse.getId() );
        order.setMoment( orderResponse.getMoment() );
        order.setOrderStatus( orderResponse.getOrderStatus() );
        order.setClient( clientResponseToClient( orderResponse.getClient() ) );

        return order;
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setMoment( order.getMoment() );
        orderResponse.setOrderStatus( order.getOrderStatus() );
        orderResponse.setClient( clientToClientResponse( order.getClient() ) );

        return orderResponse;
    }

    protected Set<Order> orderResponseSetToOrderSet(Set<OrderResponse> set) {
        if ( set == null ) {
            return null;
        }

        Set<Order> set1 = new HashSet<Order>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderResponse orderResponse : set ) {
            set1.add( toOrder( orderResponse ) );
        }

        return set1;
    }

    protected Client clientResponseToClient(ClientResponse clientResponse) {
        if ( clientResponse == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientResponse.getId() );
        client.setName( clientResponse.getName() );
        client.setEmail( clientResponse.getEmail() );
        client.setPhone( clientResponse.getPhone() );
        if ( client.getOrders() != null ) {
            Set<Order> set = orderResponseSetToOrderSet( clientResponse.getOrders() );
            if ( set != null ) {
                client.getOrders().addAll( set );
            }
        }

        return client;
    }

    protected Set<OrderResponse> orderSetToOrderResponseSet(Set<Order> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderResponse> set1 = new HashSet<OrderResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Order order : set ) {
            set1.add( toOrderResponse( order ) );
        }

        return set1;
    }

    protected ClientResponse clientToClientResponse(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setId( client.getId() );
        clientResponse.setName( client.getName() );
        clientResponse.setEmail( client.getEmail() );
        clientResponse.setPhone( client.getPhone() );
        if ( clientResponse.getOrders() != null ) {
            Set<OrderResponse> set = orderSetToOrderResponseSet( client.getOrders() );
            if ( set != null ) {
                clientResponse.getOrders().addAll( set );
            }
        }

        return clientResponse;
    }
}
