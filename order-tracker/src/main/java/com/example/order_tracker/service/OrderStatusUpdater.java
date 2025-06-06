package com.example.order_tracker.service;

import com.example.order_tracker.model.Order;
import com.example.order_tracker.model.OrderStatus;
import com.example.order_tracker.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderStatusUpdater {
    private final OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(OrderStatusUpdater.class);

    public OrderStatusUpdater(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void updateNextStatus() {
        List<Order> orders = orderRepository.findByStatusNot(OrderStatus.DELIVERED);

        for(Order order :orders) {
            OrderStatus current = order.getStatus();
            OrderStatus next =getNextStatus(current);

            if(next!=null) {
                order.setStatus(next);
                order.setUpdatedAt(LocalDateTime.now());
                orderRepository.save(order);
                log.info("[Kafka Consumer Simulation] Order {} updated from {} to {}", order.getId(), current, next);
            }
        }
    }

    public OrderStatus getNextStatus (OrderStatus current) {
        return switch(current) {
            case PLACED -> OrderStatus.PROCESSING;
            case PROCESSING -> OrderStatus.SHIPPED;
            case SHIPPED -> OrderStatus.DELIVERED;
            default -> null;
        };
    }
}
