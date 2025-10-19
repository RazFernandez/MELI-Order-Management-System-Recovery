package com.meli.meli_app.model;

// 1. Add these imports
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    // 2. Replace the old @Column annotation with this
    @CreationTimestamp
    @Column(name = "date", updatable = false)
    private LocalDateTime date;

    private String status;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    // 3. Add this annotation to manage the relationship
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    // --- Constructors ---
    public Order() {
    }

    public Order(Integer orderId, LocalDateTime date, String status, BigDecimal totalAmount, Customer customer,
            List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    // --- Getters and Setters (No changes) ---
    // ... (all your getters and setters remain the same) ...

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}