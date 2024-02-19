package com.harbour.courierQuest.controller;

import com.harbour.courierQuest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public void login(@RequestBody String username, @RequestBody String password) {
       authService.login(username, password);
    }

    @PostMapping("/register")
    public void register(@RequestBody String name, @RequestBody String username, @RequestBody String password) {
        authService.register(
               name, username, password
        );
    }

    @PostMapping("/logout")
    public void logout() {
    }
}
