package com.example.yummy_proj_1.controllers;

import com.example.yummy_proj_1.dto.CustomerRequest;
import com.example.yummy_proj_1.dto.LoginRequest;
import com.example.yummy_proj_1.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class CustomerController {
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
}
