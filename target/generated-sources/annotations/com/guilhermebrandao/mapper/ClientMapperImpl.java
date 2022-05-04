package com.guilhermebrandao.mapper;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.request.ClientGetRequestBody;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T11:37:28-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toClient(ClientPutRequestBody clientPutRequestBody) {
        if ( clientPutRequestBody == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientPutRequestBody.getId() );
        client.setName( clientPutRequestBody.getName() );
        client.setEmail( clientPutRequestBody.getEmail() );
        client.setPhone( clientPutRequestBody.getPhone() );

        return client;
    }

    @Override
    public Client toClient(ClientPostRequestBody clientPostRequestBody) {
        if ( clientPostRequestBody == null ) {
            return null;
        }

        Client client = new Client();

        client.setName( clientPostRequestBody.getName() );
        client.setEmail( clientPostRequestBody.getEmail() );
        client.setPhone( clientPostRequestBody.getPhone() );
        client.setPassword( clientPostRequestBody.getPassword() );

        return client;
    }

    @Override
    public ClientGetRequestBody toClientGetRequestBody(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientGetRequestBody clientGetRequestBody = new ClientGetRequestBody();

        clientGetRequestBody.setId( client.getId() );
        clientGetRequestBody.setName( client.getName() );
        clientGetRequestBody.setEmail( client.getEmail() );
        clientGetRequestBody.setPhone( client.getPhone() );
        if ( clientGetRequestBody.getOrders() != null ) {
            Set<Order> set = client.getOrders();
            if ( set != null ) {
                clientGetRequestBody.getOrders().addAll( set );
            }
        }

        return clientGetRequestBody;
    }
}
