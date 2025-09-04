package com.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    @Transactional(propagation = Propagation.SUPPORTS)
    public void logBooking(Long bookingId) {
        System.out.println("Audit log for booking: " + bookingId);
    }
}
