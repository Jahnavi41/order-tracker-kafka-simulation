package com.example.order_tracker.repository;

import com.example.order_tracker.model.OrderStatus;
import com.example.order_tracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatusNot(OrderStatus status);
}
