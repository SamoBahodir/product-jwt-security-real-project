package com.productexseption.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello Admin";
    }
}
