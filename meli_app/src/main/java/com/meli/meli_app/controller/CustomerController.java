package com.meli.meli_app.controller;

import com.meli.meli_app.model.Customer;
import com.meli.meli_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers") // Base URL for all customer-related endpoints
public class CustomerController {

    @Autowired // Spring injects the repository bean for us
    private CustomerRepository customerRepository;

    /**
     * Creates a new customer.
     * Endpoint: POST /api/customers
     */
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // The .save() method performs the INSERT SQL statement
        Customer savedCustomer = customerRepository.save(customer);

        // Return the saved object and a 201 Created status
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}