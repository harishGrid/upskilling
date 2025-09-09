package com.payment;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.payment.dto.OrderEvent;
import com.payment.service.PaymentService;

@Component
public class PaymentListener {

    private final PaymentService paymentService;

    public PaymentListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(
        topics = "order-events",
        groupId = "payment-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(OrderEvent orderEvent) {
        paymentService.handleOrderCreated(orderEvent);
    }
}
