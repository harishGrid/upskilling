package com.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {}
