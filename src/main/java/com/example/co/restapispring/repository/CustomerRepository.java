package com.example.co.restapispring.repository;

import com.example.co.restapispring.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
