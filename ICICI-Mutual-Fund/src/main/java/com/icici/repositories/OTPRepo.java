package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.OTP;

public interface OTPRepo extends JpaRepository<OTP, Long> {

	OTP findByUserIdAndOtpCode(Long userId, String otpCode);

}
