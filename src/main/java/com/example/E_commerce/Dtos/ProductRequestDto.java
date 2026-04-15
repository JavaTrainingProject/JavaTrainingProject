package com.example.E_commerce.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDto {
    @NotBlank
    private String name;
    private String description;

    @NotNull
    private double price;
    private int quantity;

    private String imageUrl;

    private Long categoryId;
    private Long subCategoryId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getSubCategoryId() { return subCategoryId; }


}

//    public Long getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public Long getSubCategoryId() {
//        return subCategoryId;
//    }
//
//    public void setSubCategoryId(Long subCategoryId) {
//        this.subCategoryId = subCategoryId;
//    }


