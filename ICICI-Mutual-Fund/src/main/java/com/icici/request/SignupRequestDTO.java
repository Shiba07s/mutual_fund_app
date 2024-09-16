package com.icici.request;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}