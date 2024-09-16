package com.icici.response;

import lombok.Data;

@Data
public class SigninResponseDTO {
    private String token;
    private String type = "Bearer";
}