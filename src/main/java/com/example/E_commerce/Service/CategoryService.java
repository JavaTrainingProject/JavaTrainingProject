package com.example.E_commerce.Service;


import com.example.E_commerce.Dtos.CategoryRequestDto;
import com.example.E_commerce.Dtos.CategoryResponseDto;

public interface CategoryService {
        CategoryResponseDto createCategory(CategoryRequestDto dto);
    Long getActiveCategoryCount();
    }

