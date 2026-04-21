package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto getCategoryById(Long id);

    List<CategoryResponseDto> getActiveCategories();
}