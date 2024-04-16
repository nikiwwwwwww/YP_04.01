package com.example.pr2.dao;

import com.example.pr2.models.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDAO {
    private static int ORDER_COUNT;
    private final List<Order> orders;

    {
        orders = new ArrayList<>();

        orders.add(new Order(++ORDER_COUNT, new Date(System.currentTimeMillis()), "Order1", "Pending"));
        orders.add(new Order(++ORDER_COUNT, new Date(System.currentTimeMillis()), "Order2", "Processing"));
        orders.add(new Order(++ORDER_COUNT, new Date(System.currentTimeMillis()), "Order3", "Completed"));
    }

    public List<Order> index() {
        return orders;
    }

    public Order show(int id) {
        return orders.stream().filter(order -> order.getId() == id).findAny().orElse(null);
    }

    public void save(Order order) {
        order.setId(++ORDER_COUNT);
        orders.add(order);
    }

    public void update(int id, Order updatedOrder) {
        Order orderToBeUpdated = show(id);

        if (orderToBeUpdated != null) {
            orderToBeUpdated.setName(updatedOrder.getName());
            orderToBeUpdated.setOrderDate(updatedOrder.getOrderDate());
            orderToBeUpdated.setStatus(updatedOrder.getStatus());
        }
    }

    public void delete(int id) {
        orders.removeIf(o -> o.getId() == id);
    }
}