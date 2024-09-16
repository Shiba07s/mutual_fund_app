package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.Investment;

public interface InvestmentRepo extends JpaRepository<Investment, Long> {

}
