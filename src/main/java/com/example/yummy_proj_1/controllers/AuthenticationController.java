package com.example.yummy_proj_1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.yummy_proj_1.dto.CustomerRequest;
import com.example.yummy_proj_1.dto.LoginRequest;
import com.example.yummy_proj_1.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(customerService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}