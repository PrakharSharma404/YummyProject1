package com.example.yummy_proj_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;
    @Column(name="last_name", nullable=false)
    private String lastName;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="password", nullable=false)
    private String password;
    @Column(name="city", nullable = false)
    private String city;
    @Column(name="address", nullable = false)
    private String addr;
    @Column(name = "pin_code", nullable = false)
    private String pinCode;
}
