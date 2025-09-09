package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.payment.dto.OrderEvent;
import com.payment.dto.PaymentEvent;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PaymentService {
	
	@Autowired
	private KafkaTemplate<String, PaymentEvent> kafkaTemplate;
	
	@CircuitBreaker(name = "paymentService", fallbackMethod = "callpaymentCallback")
	@Retry(name = "paymentService", fallbackMethod = "callpaymentCallback")
	public void handleOrderCreated(OrderEvent event) {
		 System.out.println("Received OrderCreated event for Order ID: " + event.getOrderId());
	        
		 boolean isPaymentSuccesful=Math.random()>0.1;
		 
		 PaymentEvent paymentEvent = new PaymentEvent();
		 paymentEvent.setOrderId(event.getOrderId());
		 
		 if(isPaymentSuccesful) {
			 System.out.println("Payment successful for Order ID: " + event.getOrderId());
			 paymentEvent.setStatus("PAYMENT_PROCESSED");
			 kafkaTemplate.send("payment-events",paymentEvent);
		 }else {
	            System.out.println("Payment failed for Order ID: " + event.getOrderId());
	            paymentEvent.setStatus("PAYMENT_FAILED");
	            kafkaTemplate.send("payment-events", paymentEvent);
	        }
	}
	
	// Correct fallback for void method
    public void callpaymentCallback(OrderEvent event, Throwable t) {
        System.out.println("Fallback triggered for Order ID: " + event.getOrderId() + " due to " + t.getMessage());
        // Optionally, send failed event to Kafka
        PaymentEvent fallbackEvent = new PaymentEvent(event.getOrderId(), "PAYMENT_FAILED_FALLBACK");
        kafkaTemplate.send("payment-events", fallbackEvent);
    }

}
