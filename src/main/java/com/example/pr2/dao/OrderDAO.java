package com.example.pr2.dao;

import com.example.pr2.Repository.OrderRepository;
import com.example.pr2.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> index() {
        return orderRepository.findAll();
    }
    public Order show(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
    public void update(int id, Order updatedOrder) {
        Order orderToBeUpdated = show(id);
        if (orderToBeUpdated != null) {
            orderToBeUpdated.setName(updatedOrder.getName());
            orderToBeUpdated.setOrderDate(updatedOrder.getOrderDate());
            orderToBeUpdated.setStatus(updatedOrder.getStatus());
            orderRepository.save(orderToBeUpdated);
        }
    }
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}