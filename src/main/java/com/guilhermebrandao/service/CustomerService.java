package com.guilhermebrandao.service;

import com.guilhermebrandao.dao.customer.CustomerDaoImpl;
import com.guilhermebrandao.dao.order.OrderDaoImpl;
import com.guilhermebrandao.domain.Customer;
import com.guilhermebrandao.infra.security.PasswordValidator;
//import com.guilhermebrandao.mapper.Customer;
import com.guilhermebrandao.mapper.CustomerMapper;
import com.guilhermebrandao.request.CustomerPostRequestBody;
import com.guilhermebrandao.response.CustomerResponse;
import com.guilhermebrandao.request.CustomerPutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDaoImpl customerDaoImpl;
    private final OrderDaoImpl orderDaoImpl;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerDaoImpl customerDaoImpl, CustomerMapper customerMapper, OrderDaoImpl orderDaoImpl){
        this.customerDaoImpl = customerDaoImpl;
        this.customerMapper = customerMapper;
        this.orderDaoImpl = orderDaoImpl;
    }

    public List<CustomerResponse> findAll() {
        return customerDaoImpl.findAll().stream().map(customer ->
                customerMapper.toCustomerResponse(customer)).collect(Collectors.toList());
    }

    public CustomerResponse findById(Long id) {
        Customer customer = (Customer) customerDaoImpl.findById(id).get();
        customer.addOrders(orderDaoImpl.findAllByCustomerId(id));
        return this.customerMapper.toCustomerResponse(customer);
    }

    public CustomerResponse insert(CustomerPostRequestBody customerPostRequestBody) {
        Customer customer = this.customerMapper.toCustomer(customerPostRequestBody);
        PasswordValidator.validateCustomerPassword(customer.getPassword());
        Customer insertedCustomer = (Customer) customerDaoImpl.insert(customer).get();
        return this.customerMapper.toCustomerResponse(insertedCustomer);
    }

    public void update(CustomerPutRequestBody customerPutRequestBody) {
        Customer customer = this.customerMapper.toCustomer(customerPutRequestBody);
        customerDaoImpl.findById(customer.getId());
        customerDaoImpl.update(customer);
    }

    public void delete(Long id) {
        customerDaoImpl.findById(id);
        customerDaoImpl.delete(id);
    }

    public void updatePassword(CustomerPutRequestBody customerPutRequestBody) {
        PasswordValidator.validateNewCustomerPassword(customerPutRequestBody);
        customerDaoImpl.updatePassword(customerPutRequestBody);
    }
}
