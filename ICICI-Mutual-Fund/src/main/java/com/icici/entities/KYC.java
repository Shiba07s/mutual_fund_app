package com.icici.entities;


import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "kyc_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KYC {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String panCardNumber;
    
    private String aadhaarNumber;
    
    private String addressProofUrl;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    
}
