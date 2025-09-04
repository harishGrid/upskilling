package com.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void sendEmail(String message) {
        System.out.println("Email sent: " + message);
    }
}
