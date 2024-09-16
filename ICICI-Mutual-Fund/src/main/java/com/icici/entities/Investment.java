package com.icici.entities;

 
import java.time.LocalDate;

import com.icici.constants.InvestmentMode;
import com.icici.constants.InvestmentOption;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double amount;
    
    @Enumerated(EnumType.STRING)
    private InvestmentMode investmentMode; // Lump Sum or SIP
    
    @Enumerated(EnumType.STRING)
    private InvestmentOption investmentOption; // Growth or Dividend
    
    private LocalDate startDate;
    
    private String frequency; // Applicable for SIP
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "mutual_fund_id")
    private MutualFund mutualFund;
}
