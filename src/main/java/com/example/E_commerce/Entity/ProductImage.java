package com.example.E_commerce.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}