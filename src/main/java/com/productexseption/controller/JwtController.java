package com.productexseption.controller;

import com.productexseption.core.SuccessfulResponse;
import com.productexseption.model.role.Role;
import com.productexseption.model.user.LoginRequest;
import com.productexseption.model.user.User;
import com.productexseption.model.user.UserRepository;
import com.productexseption.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class JwtController {
    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

//    @PostMapping("/login")
//    public SuccessfulResponse<Map<Object, Object>> create(@RequestBody LoginRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()));
//        User user = userRepository.findByUsername(request.getUsername());
//        if (user == null) {
//            throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas");
//        }
//
//        String token = tokenProvider.createToken(user.getCode(), user.getRoles());
//        Map<Object, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("username", user.getUsername());
//        map.put("role", user.getRoles().stream().map(Role::getName));
//        return new SuccessfulResponse<>(map, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public SuccessfulResponse<Map<Object, Object>> login(@RequestParam String password,
                                                           @RequestParam String username) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password));
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas");
        }

        String token = tokenProvider.createToken(user.getCode(), user.getRoles());
        Map<Object, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("username", user.getUsername());
        map.put("role", user.getRoles().stream().map(Role::getName));
        return new SuccessfulResponse<>(map, HttpStatus.OK);
    }
}
