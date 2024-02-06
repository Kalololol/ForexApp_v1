package com.example.ForexApp_v1.logic;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashing {
    private BCryptPasswordEncoder passwordEncoder;

    public PasswordHashing(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hidePassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(String firstPassword, String secondPassword){
        return passwordEncoder.matches(firstPassword, secondPassword);
    }


}
