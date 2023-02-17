package com.productexseption.model.user;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
