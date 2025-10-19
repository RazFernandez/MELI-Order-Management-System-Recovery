package com.meli.meli_app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    // --- Constructors ---

    // No-argument constructor (required by JPA)
    public Customer() {
    }

    // All-argument constructor (replaces @AllArgsConstructor)
    public Customer(Integer customerId, String name, String email, String password, List<Order> orders) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = orders;
    }

    // --- Getters and Setters (replaces @Data) ---

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}