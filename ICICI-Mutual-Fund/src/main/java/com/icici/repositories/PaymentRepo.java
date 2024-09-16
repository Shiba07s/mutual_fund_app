package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
