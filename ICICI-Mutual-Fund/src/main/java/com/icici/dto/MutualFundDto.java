package com.icici.dto;

import com.icici.constants.FundType;
import com.icici.constants.RiskLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFundDto {
    
    private Long id;
    private String fundName;
    private FundType fundType;
    private RiskLevel riskLevel;
    private String description;
    private double nav; // Net Asset Value
}