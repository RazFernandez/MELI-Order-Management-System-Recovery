package com.meli.meli_app.service;

import com.meli.meli_app.exception.ResourceNotFoundException;
import com.meli.meli_app.model.Order;
import com.meli.meli_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Order createOrder(Order order) {
        // In a real app, this is where you'd fetch products,
        // check stock, and calculate the total_amount
        // For now, we just save the order as-is.
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer id, Order orderDetails) {
        Order order = getOrderById(id);

        order.setStatus(orderDetails.getStatus());
        // You might want to update other fields, e.g., customer, items, etc.
        // Be careful: updating totalAmount or customer_id here might be complex.
        // For now, we'll just update the status.
        order.setStatus(orderDetails.getStatus());

        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}