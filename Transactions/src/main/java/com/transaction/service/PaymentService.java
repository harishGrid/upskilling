package com.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.entity.Payment;
import com.transaction.repo.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processPayment(Long bookingId, double amount) {
        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(amount);
        payment.setStatus("PAID");
        paymentRepo.save(payment);
        System.out.println("Payment processed independently: " + payment.getId());
    }
}
