package com.guilhermebrandao.controller;

import com.guilhermebrandao.request.CustomerPutRequestBody;
import com.guilhermebrandao.response.CustomerResponse;
import com.guilhermebrandao.request.CustomerPostRequestBody;
import com.guilhermebrandao.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok().body(customerService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<CustomerResponse> insert(@RequestBody CustomerPostRequestBody customerPostRequestBody){
        CustomerResponse customerResponse = customerService.insert(customerPostRequestBody);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CustomerPutRequestBody customerPutRequestBody, @PathVariable Long id) {
        customerPutRequestBody.setId(id);
        customerService.update(customerPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}/new_password")
    public ResponseEntity<Void> updatePassword(@RequestBody CustomerPutRequestBody customerPutRequestBody, @PathVariable Long id) {
        customerPutRequestBody.setId(id);
        customerService.updatePassword(customerPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
