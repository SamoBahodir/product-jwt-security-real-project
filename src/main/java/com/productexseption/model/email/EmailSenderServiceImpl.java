package com.productexseption.model.email;

import com.productexseption.model.user.User;
import com.productexseption.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String password,String username,String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setText("http://localhost:8080/v1/login?password="+password+"&username="+username);
        mailMessage.setFrom("turayev.bahodir95@gmail.com");
        mailMessage.setSubject("subject");
        mailMessage.setTo(email);
        this.javaMailSender.send(mailMessage);
    }
}
