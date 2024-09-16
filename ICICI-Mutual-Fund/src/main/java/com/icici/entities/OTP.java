package com.icici.entities;


import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String otpCode;
    
    private LocalDateTime expiryTime;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
