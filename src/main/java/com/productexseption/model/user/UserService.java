package com.productexseption.model.user;

import com.productexseption.core.CodeGenerateUtil;
import com.productexseption.core.enumeration.Status;
import com.productexseption.model.email.EmailSenderService;
import com.productexseption.sms.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final SmsService smsService;

//    public UserResponse create(UserPayload payload) {
//        var user = new User();
//        String password= payload.getPassword();
//        payload.setPassword(passwordEncoder.encode(payload.getPassword()));
//        payload.setStatus(Status.ACTIVE);
//        String code = UUID.randomUUID().toString();
//        user.setCode(code);
//        user.setUsername(payload.getUsername());
//        user.setRoles(payload.getRoles());
//        user.setEmail(payload.getEmail());
//        user.setFirstname(payload.getFirstname());
//        user.setLastname(payload.getLastname());
//        user.setPassword(payload.getPassword());
//        user.setStatus(payload.getStatus());
//        userRepository.save(user);
//        emailSenderService.sendEmail(
//                password,
//                payload.getUsername(),
//                payload.getEmail());
//        return new UserResponse(user);
//    }

    public UserResponse create(UserPayload payload) {
        var user = new User();
        String password = payload.getPassword();
        payload.setPassword(passwordEncoder.encode(payload.getPassword()));
        payload.setStatus(Status.ACTIVE);
        String code = UUID.randomUUID().toString();
        user.setCode(code);
        user.setUsername(payload.getUsername());
        user.setRoles(payload.getRoles());
        user.setEmail(payload.getEmail());
        user.setFirstname(payload.getFirstname());
        user.setLastname(payload.getLastname());
        user.setPassword(payload.getPassword());
        user.setStatus(payload.getStatus());
        userRepository.save(user);
        String generateCode = CodeGenerateUtil.generateCode(6);
        smsService.create(user.getId(),
                "+998939434399",
                "Tastiqlash kodi: " + generateCode);
        return new UserResponse(user);
    }

    public Boolean checkUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

}
