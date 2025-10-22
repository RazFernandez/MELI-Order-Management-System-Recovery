package com.meli.meli_app;

import com.meli.meli_app.controller.OrderController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.meli_app.model.Customer;
import com.meli.meli_app.model.Order;
import com.meli.meli_app.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateOrder() throws Exception {
        Customer customer = new Customer(1, "John", "john@example.com", "1234", null);
        Order order = new Order(1, LocalDateTime.now(), "Pending", new BigDecimal("100.00"), customer, null);

        Mockito.when(orderService.createOrder(Mockito.any(Order.class))).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("Pending"));
    }

    @Test
    void shouldGetAllOrders() throws Exception {
        Customer customer = new Customer(1, "John", "john@example.com", "1234", null);
        List<Order> orders = List.of(
                new Order(1, LocalDateTime.now(), "Pending", new BigDecimal("100.00"), customer, null));

        Mockito.when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("Pending"));
    }
}
