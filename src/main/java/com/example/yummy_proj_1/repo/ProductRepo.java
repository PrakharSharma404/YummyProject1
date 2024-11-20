package com.example.yummy_proj_1.repo;

import com.example.yummy_proj_1.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {
    @Query("select p from Products p where p.price BETWEEN :low and :high")
    List<Products> getProductByPrice(@Param("low") Double low, @Param("high") Double high);
}
