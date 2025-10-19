package com.meli.meli_app.model;

// 1. Add this import
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // 2. Add this annotation to break the loop
    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    // --- Constructors ---
    public Customer() {
    }

    public Customer(Integer customerId, String name, String email, String password, List<Order> orders) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = orders;
    }

    // --- Getters and Setters (No changes) ---
    // ... (all your getters and setters remain the same) ...

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