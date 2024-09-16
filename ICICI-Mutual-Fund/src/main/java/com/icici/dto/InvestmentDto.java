package com.icici.dto;

import java.time.LocalDate;
import java.util.List;

import com.icici.constants.InvestmentMode;
import com.icici.constants.InvestmentOption;
import com.icici.entities.MutualFund;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvestmentDto {

    private Long id;
    private double amount;
    private InvestmentMode investmentMode; // Lump Sum or SIP
    private InvestmentOption investmentOption; // Growth or Dividend
    private LocalDate startDate;
    private String frequency; // Applicable for SIP
    
//    private UserDto userDto;
    private MutualFund mutualFund;
}
