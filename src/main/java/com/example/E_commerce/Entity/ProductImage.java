package com.example.E_commerce.Entity;

import jakarta.persistence.*;

@Entity
public class ProductImage {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String imageFile;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;

        public String getImageFile() {
            return imageFile;
        }

        public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }