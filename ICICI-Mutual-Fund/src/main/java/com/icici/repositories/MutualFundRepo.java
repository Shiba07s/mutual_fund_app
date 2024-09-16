package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.MutualFund;

public interface MutualFundRepo extends JpaRepository<MutualFund, Long> {

}
