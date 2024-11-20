package com.example.yummy_proj_1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(

        @JsonProperty("name")
        String name,

        @JsonProperty("price")
        double price
) {
}