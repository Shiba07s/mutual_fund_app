package com.icici.entities;

 
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double amount;
    
    private String paymentMethod; // UPI, Net Banking, etc.
    
    private LocalDateTime paymentDate;
    
    private String paymentStatus; // Success, Pending, Failed
    
    @OneToOne
    @JoinColumn(name = "investment_id")
    private Investment investment;
}
