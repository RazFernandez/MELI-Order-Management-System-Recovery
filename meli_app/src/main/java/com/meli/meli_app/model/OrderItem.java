package com.meli.meli_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitem_id")
    private Integer orderItemId;

    private int quantity;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore // <-- KEEP THIS. It's not Lombok.
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // --- Constructors ---

    public OrderItem() {
    }

    public OrderItem(Integer orderItemId, int quantity, BigDecimal subtotal, Order order, Product product) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.order = order;
        this.product = product;
    }

    // --- Getters and Setters ---

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
}

    public void setProduct(Product product) {
        this.product = product;
    }
}