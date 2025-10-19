package com.meli.meli_app.controller;

import com.meli.meli_app.model.Product;
import com.meli.meli_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products") // Base URL for all product-related endpoints
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates a new product.
     * Endpoint: POST /api/products
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // The .save() method performs the INSERT SQL statement
        Product savedProduct = productRepository.save(product);

        // Return the saved object and a 201 Created status
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}