package com.example.co.restapispring.serviceImpl;

import com.example.co.restapispring.domain.Customer;
import com.example.co.restapispring.repository.CustomerRepository;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.*;


import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    CustomerServiceImpl customerService;

    @BeforeEach
    public void setup() {
        customerService = new CustomerServiceImpl(customerRepository);
    }


    @Test
    @DisplayName("Should Find Customer By Id")
    void shouldFindCustomerById() {
        Customer customer = new Customer(1L, "Erick", "Romero");
        //Return customer object
        Customer ExpectedCustomerResponse = new Customer(1L, "Erick", "Romero");
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Customer customerResponse = customerService.findCustomerById(1L);
        //Assertions.assertThat(customerResponse.getId()).isEqualTo(ExpectedCustomerResponse.getId());
        Assertions.assertEquals(customerResponse.getId(), ExpectedCustomerResponse.getId());
    }

    private static List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Micahale", "Weston"),
                new Customer(1L, "Sam", "Axe"),
                new Customer(1L, "Fiona", "Glennann"));
    }

    @DisplayName("Should Find All Customers")
    @Test
    void shouldFindAllCustomers() {

        List<Customer> customersList = getCustomers();
        Mockito.when(customerRepository.findAll()).thenReturn(customersList);

        List<Customer> customersResponse = customerService.findAllCustomers();

        Assertions.assertFalse(customersResponse.isEmpty());
        Assertions.assertEquals(customersList.size(), customersResponse.size());

    }

    @Test
    @DisplayName("Should Save Customer ")
    void saveCustomer() {

        Customer customerRequest = new Customer(null, "Maria", "Ruiz");
        Customer customerResponse = new Customer(4l, "Maria", "Ruiz");
        Mockito.when(customerRepository.save(customerRequest)).thenReturn(customerResponse);
        customerRepository.save(customerRequest);
        Mockito.verify(customerRepository,Mockito.times(1)).save(ArgumentMatchers.any(Customer.class));
        Assertions.assertEquals(customerResponse.getId(), 4L);
        Assertions.assertEquals(customerResponse.getFirstname(), "Maria");
    }
}