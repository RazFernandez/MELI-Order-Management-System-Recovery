package com.meli.meli_app.repository;

import com.meli.meli_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<EntityType, PrimaryKeyType>
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}