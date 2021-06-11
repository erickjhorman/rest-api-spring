package com.example.co.restapispring.serviceimpl;

import com.example.co.restapispring.domain.Customer;
import com.example.co.restapispring.repository.CustomerRepository;
import com.example.co.restapispring.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // Test comment
    // Test comment 2
    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }


    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
