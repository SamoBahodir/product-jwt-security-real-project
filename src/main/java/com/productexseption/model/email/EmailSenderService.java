package com.productexseption.model.email;

public interface EmailSenderService {
    void sendEmail(String password,String username,String email);
}
