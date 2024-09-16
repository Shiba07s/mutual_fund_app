package com.icici.dto;

import java.util.List;

import com.icici.entities.Investment;
import com.icici.entities.KYC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean isKycVerified;
    private KYCDto kyc;
    private List<InvestmentDto> investments;


}
