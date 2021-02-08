package com.example.co.restapispring.service;

import com.example.co.restapispring.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);
}
