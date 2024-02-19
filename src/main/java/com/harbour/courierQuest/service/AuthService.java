package com.harbour.courierQuest.service;

import com.harbour.courierQuest.database.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CourierRepository courierRepository;


    public void login(String username, String password) {

    }


    public void register(String name,String username, String password) {

    }
}
