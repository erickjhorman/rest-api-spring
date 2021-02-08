package com.example.co.restapispring.bootstrap;

import com.example.co.restapispring.domain.Customer;
import com.example.co.restapispring.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public BootstrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstname("Michale");
        c1.setLastname("Weston");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstname("Sam");
        c2.setLastname("Axe");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstname("Fiona");
        c3.setLastname("Glennann");
        customerRepository.save(c3);

        log.info("Customers Saved: " + customerRepository.count());
    }
}
