package com.example.yummy_proj_1.mapper;

import com.example.yummy_proj_1.dto.CustomerRequest;
import com.example.yummy_proj_1.dto.CustomerResponse;
import com.example.yummy_proj_1.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .addr(request.addr())
                .city(request.city())
                .pinCode(request.pinCode())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddr(),
                customer.getCity(),
                customer.getPinCode()
        );
    }
}