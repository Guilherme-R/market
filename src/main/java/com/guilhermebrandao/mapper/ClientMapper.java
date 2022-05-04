package com.guilhermebrandao.mapper;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.request.ClientGetRequestBody;
import com.guilhermebrandao.request.ClientPostRequestBody;
import com.guilhermebrandao.request.ClientPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientPutRequestBody clientPutRequestBody);
    Client toClient(ClientPostRequestBody clientPostRequestBody);
    ClientGetRequestBody toClientGetRequestBody(Client client);
}
