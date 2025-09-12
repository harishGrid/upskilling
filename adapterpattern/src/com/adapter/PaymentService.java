package com.adapter;

public class PaymentService {
    private final PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void process(double amount) {
        processor.pay(amount);
    }
}
