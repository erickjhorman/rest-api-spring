package com.example.co.restapispring.controller;

import com.example.co.restapispring.domain.Customer;
import com.example.co.restapispring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    public static final String BASE_URL = "/api/v1/customers";

    @GetMapping
    List<Customer> getAllCustomers(){
        System.out.println("here in getAllCustomers");
       return  customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable  Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody  Customer customer){
        return customerService.saveCustomer(customer);
    }
}
