package com.example.yummy_proj_1.helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncryptionService {

    private final PasswordEncoder passwordEncoder;

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Boolean validatePassword(String password, String encryptedPassword) {
        return passwordEncoder.matches(password, encryptedPassword);
    }

}