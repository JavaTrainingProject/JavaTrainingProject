package com.example.E_commerce.dtos;

import com.example.E_commerce.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SubCategoryRequestDto {
    @NotBlank(message = "SubCategory name is required")
    @Size(min = 2, max = 100)
    private String SubCategoryname;
    @NotBlank(message = "Description name is required")
    @Size(max = 255)
    private String SubCategorydescription;
    private Status status;
    @NotNull(message = "Category ID is required")
    private Long categoryId;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryname() {
        return SubCategoryname;
    }

    public void setSubCategoryname(String subCategoryname) {
        SubCategoryname = subCategoryname;
    }

    public String getSubCategorydescription() {
        return SubCategorydescription;
    }

    public void setSubCategorydescription(String subCategorydescription) {
        SubCategorydescription = subCategorydescription;
    }
}
