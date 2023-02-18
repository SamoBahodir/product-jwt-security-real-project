package com.productexseption.controller;

import com.productexseption.model.user.LoginRequest;
import com.productexseption.model.user.User;
import com.productexseption.model.user.UserRepository;
import com.productexseption.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JwtController {
    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity create(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas");
        }
        String token = tokenProvider.createToken(user.getUsername(), user.getRoles());
        Map<Object, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("token", token);
        return ResponseEntity.ok(map);
    }
}
