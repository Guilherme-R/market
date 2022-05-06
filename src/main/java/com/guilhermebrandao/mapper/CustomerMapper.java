package com.guilhermebrandao.mapper;

import com.guilhermebrandao.domain.Customer;
import com.guilhermebrandao.response.CustomerResponse;
import com.guilhermebrandao.request.CustomerPostRequestBody;
import com.guilhermebrandao.request.CustomerPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerPutRequestBody customerPutRequestBody);
    Customer toCustomer(CustomerPostRequestBody customerPostRequestBody);

    Customer toCustomer(CustomerResponse customerResponse);
    CustomerResponse toCustomerResponse(Customer customer);
}
