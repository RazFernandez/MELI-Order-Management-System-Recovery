package com.meli.meli_app.service;

import com.meli.meli_app.exception.ResourceNotFoundException;
import com.meli.meli_app.model.Order;
import com.meli.meli_app.model.OrderItem; // <-- Make sure this is imported
import com.meli.meli_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <-- Import this

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    // --- THIS IS THE FIXED METHOD ---
    @Transactional // Ensures this all happens in one database transaction
    public Order createOrder(Order order) {

        // 1. Manually link the child items back to the parent order
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                // This sets the order_id foreign key on the order_item
                item.setOrder(order);
            }
        }

        // 2. Now, save the order.
        // Because of CascadeType.ALL, saving the order will
        // also save all the linked OrderItem objects.
        return orderRepository.save(order);
    }
    // ---------------------------------

    public Order updateOrder(Integer id, Order orderDetails) {
        Order order = getOrderById(id);

        // We only allow updating the status
        order.setStatus(orderDetails.getStatus());

        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}