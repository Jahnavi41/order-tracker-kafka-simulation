package com.example.order_tracker.controller;

import com.example.order_tracker.model.Order;
import com.example.order_tracker.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder() {
        return orderService.placeOrder();
    }

    @GetMapping
    public Optional<Order> getOrder(@RequestParam(name= "id", required= true) Long id) {
        return orderService.getOrder(id);
    }
}
