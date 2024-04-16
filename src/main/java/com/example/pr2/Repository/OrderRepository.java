package com.example.pr2.Repository;

import com.example.pr2.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByNameContaining(String name);

}
