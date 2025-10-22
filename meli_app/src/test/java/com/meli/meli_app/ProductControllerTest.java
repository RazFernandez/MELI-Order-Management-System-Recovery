package com.meli.meli_app;

import com.meli.meli_app.controller.ProductController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.meli_app.model.Product;
import com.meli.meli_app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProduct() throws Exception {
        Product product = new Product(1, "Laptop", "Gaming Laptop", new BigDecimal("1500.00"), 10);
        Mockito.when(productService.createProduct(Mockito.any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void shouldGetAllProducts() throws Exception {
        List<Product> products = List.of(
                new Product(1, "Laptop", "Gaming Laptop", new BigDecimal("1500.00"), 10),
                new Product(2, "Mouse", "Wireless Mouse", new BigDecimal("25.99"), 50));

        Mockito.when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[1].name").value("Mouse"));
    }
}
