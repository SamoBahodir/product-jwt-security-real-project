package com.productexseption.controller;

import com.productexseption.core.SuccessfulResponse;
import com.productexseption.model.user.UserPayload;
import com.productexseption.model.user.UserResponse;
import com.productexseption.model.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public SuccessfulResponse<UserResponse> create(@RequestBody UserPayload userPayload) {
        if (!checkPassword(userPayload.getPassword())) {
            return new SuccessfulResponse<>("parol uzunligi 4 dan kam ", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUsername(userPayload.getUsername())) {
            return new SuccessfulResponse<>("bu user oldin royhatdan o'tkan ", HttpStatus.BAD_REQUEST);
        }
        return new SuccessfulResponse<>(userService.create(userPayload),HttpStatus.OK);
    }

    public Boolean checkPassword(String password) {
        return password.length() >= 4;
    }
}
