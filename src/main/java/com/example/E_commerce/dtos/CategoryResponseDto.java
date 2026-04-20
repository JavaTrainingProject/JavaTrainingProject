package com.example.E_commerce.dtos;

import java.time.LocalDateTime;

public class CategoryResponseDto {
    private Long id;
    private String Categoryname;
    private String Categorydescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String categoryname) {
        Categoryname = categoryname;
    }

    public String getCategorydescription() {
        return Categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        Categorydescription = categorydescription;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
