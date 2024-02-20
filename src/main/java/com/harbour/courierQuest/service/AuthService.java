package com.harbour.courierQuest.service;

import com.harbour.courierQuest.config.SecurityConfig;
import com.harbour.courierQuest.database.Courier;
import com.harbour.courierQuest.database.CourierRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${JWT_SECRET:default_secret_key}")
    private String SECRET_KEY;
    private static final long EXPIRATION_TIME = 86400000; // 24 hours in milliseconds

    public void login(String email, String password, HttpServletResponse response) {
        Courier courier = courierRepository.findByEmail(email);
        if (courier != null && passwordEncoder.matches(password, courier.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(email)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge((int) EXPIRATION_TIME / 1000);
            response.addCookie(cookie);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public void register(String name, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Courier newCourier = new Courier(name, email, encodedPassword);
        courierRepository.save(newCourier);
    }
}

