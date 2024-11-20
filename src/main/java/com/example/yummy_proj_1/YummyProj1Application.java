package com.example.yummy_proj_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class YummyProj1Application {

    public static void main(String[] args) {
        SpringApplication.run(YummyProj1Application.class, args);
    }

}
