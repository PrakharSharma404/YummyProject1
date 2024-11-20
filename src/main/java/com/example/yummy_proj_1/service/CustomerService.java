package com.example.yummy_proj_1.service;

import lombok.RequiredArgsConstructor;
import com.example.yummy_proj_1.dto.CustomerRequest;
import com.example.yummy_proj_1.dto.CustomerResponse;
import com.example.yummy_proj_1.dto.LoginRequest;
import com.example.yummy_proj_1.entity.Customer;
import com.example.yummy_proj_1.exception.CustomerNotFoundException;
import com.example.yummy_proj_1.helpers.EncryptionService;
import com.example.yummy_proj_1.helpers.JWTHelper;
import com.example.yummy_proj_1.mapper.CustomerMapper;
import com.example.yummy_proj_1.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String createCustomer(CustomerRequest.CreateRequest request) {
        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encryptPassword(customer.getPassword()));
        repo.save(customer);
        return "Customer Created";
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomerByEmail(email);
        return mapper.toCustomerResponse(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public String login(LoginRequest request) {
        Customer customer = getCustomerByEmail(request.email());
        if(!encryptionService.validatePassword(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }
        return jwtHelper.generateToken(request.email());
    }

}