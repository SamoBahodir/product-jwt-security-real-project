package com.productexseption.model.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse create(UserPayload payload) {
        var user=new User();
        payload.setPassword(passwordEncoder.encode(payload.getPassword()));
        payload.setStatus(Status.ACTIVE);
        return new UserResponse(userRepository.save(user));
    }

    public Boolean checkUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

}
