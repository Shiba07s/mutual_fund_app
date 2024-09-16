package com.icici.dto;

import lombok.Data;

@Data
public class OTPDTO {
    private Long id;
    private String otpCode;
    private Long userId;  // Only sending user ID, not the whole user object
}
