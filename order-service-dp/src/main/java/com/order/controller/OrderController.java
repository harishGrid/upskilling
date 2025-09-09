package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.order.OrderRequest;
import com.order.OrderStatus;
import com.order.entity.Order;
import com.order.service.OrderService;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @Retry(name = "inventoryService", fallbackMethod = "createOrderFallback")
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "createOrderFallback")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }
    
    public ResponseEntity<Order> createOrderFallback(OrderRequest request, Throwable t) {
        System.out.println("Fallback triggered for creating order. Reason: " + t.getMessage());
        Order fallbackOrder = new Order();
        fallbackOrder.setStatus(OrderStatus.CANCELLED);
        return ResponseEntity.status(503).body(fallbackOrder);
    }
}