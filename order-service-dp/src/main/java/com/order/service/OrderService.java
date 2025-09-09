package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.order.OrderEvent;
import com.order.OrderRequest;
import com.order.OrderStatus;
import com.order.entity.Order;
import com.order.repo.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    private static final String TOPIC_NAME = "order-events";

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setAmount(request.getAmount());
        order.setProductId(request.getProductId());
        order.setStatus(OrderStatus.CREATED);
        Order savedOrder = orderRepository.save(order);
        
        // Publish OrderCreated event
        OrderEvent event = new OrderEvent(
            savedOrder.getId(), 
            savedOrder.getCustomerId(), 
            savedOrder.getAmount(), 
            savedOrder.getProductId(), 
            OrderStatus.CREATED.name()
        );
        kafkaTemplate.send(TOPIC_NAME, event);
        
        return savedOrder;
    }

    public void processPaymentFailed(Long orderId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.setStatus(OrderStatus.PAYMENT_FAILED);
            orderRepository.save(order);
        });
    }
}