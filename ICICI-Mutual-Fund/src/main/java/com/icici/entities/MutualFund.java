package com.icici.entities;

 
import lombok.*;

import com.icici.constants.FundType;
import com.icici.constants.RiskLevel;

import jakarta.persistence.*;

@Entity
@Table(name = "mutual_funds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFund {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fundName;
    
    private FundType fundType;
    
    private RiskLevel riskLevel;
    
    private String description;
    
    private double nav; // Net Asset Value
}
