package com.example.E_commerce.dtos;

import com.example.E_commerce.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryRequestDto {
    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String Categoryname;
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String Categorydescription;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
