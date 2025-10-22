package com.meli.meli_app;

import com.meli.meli_app.controller.CustomerController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.meli_app.model.Customer;
import com.meli.meli_app.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer(1, "John", "john@example.com", "1234", null);
        Mockito.when(customerService.createCustomer(Mockito.any(Customer.class)))
                .thenReturn(customer);

        mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {
        List<Customer> customers = List.of(
                new Customer(1, "John", "john@example.com", "1234", null),
                new Customer(2, "Jane", "jane@example.com", "5678", null)
        );

        Mockito.when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jane"));
    }

    @Test
    void shouldReturnCustomerById() throws Exception {
        Customer customer = new Customer(1, "John", "john@example.com", "1234", null);
        Mockito.when(customerService.getCustomerById(1)).thenReturn(customer);

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }
}
