package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.KYC;

public interface KYCRepo extends JpaRepository<KYC, Long> {

}
