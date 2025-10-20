package com.meli.meli_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data // Lombok: Creates getters, setters, toString(), etc.
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer") // Links this class to the "customer" table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Matches SERIAL
    @Column(name = "customer_id")
    private Integer customerId;

    private String name;
    private String email;
    private String password;

    // A customer can have many orders
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Order> orders;
}