package com.harbour.courierQuest.controller;

import com.harbour.courierQuest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public void login() {
       authService.login();
    }

    @PostMapping("/register")
    public void register() {
        authService.register();
    }

    @PostMapping("/logout")
    public void logout() {
    }
}
