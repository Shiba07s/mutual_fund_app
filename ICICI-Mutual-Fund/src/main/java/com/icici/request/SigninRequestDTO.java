package com.icici.request;

import lombok.Data;

@Data
public class SigninRequestDTO {
    private String email;
    private String password;
}