package com.icici.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

//    @Column(unique = true, nullable = false)
    private String email;
    
//    @Column(unique = true, nullable = false)
    private String phoneNumber;
    
    private String password;
    
    private boolean isKycVerified = false;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private KYC kyc;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Investment> investments;
}