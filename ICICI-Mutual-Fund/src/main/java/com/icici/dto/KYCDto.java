package com.icici.dto;

import com.icici.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KYCDto {
	
    private Long id;
    private String panCardNumber;
    private String aadhaarNumber;
    private String addressProofUrl;
//    private User user;
    

}
