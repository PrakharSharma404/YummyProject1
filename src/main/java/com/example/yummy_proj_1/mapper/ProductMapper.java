package com.example.yummy_proj_1.mapper;

import com.example.yummy_proj_1.dto.ProductRequest;
import com.example.yummy_proj_1.dto.ProductResponse;
import com.example.yummy_proj_1.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Products toProductEntity(ProductRequest request) {
        return Products.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }

    public ProductResponse toProductResponse(Products products) {
        return new ProductResponse(
                products.getName(),
                products.getPrice()
        );
    }
}
