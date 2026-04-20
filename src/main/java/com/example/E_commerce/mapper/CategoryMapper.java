package com.example.E_commerce.mapper;

import com.example.E_commerce.dtos.CategoryRequestDto;
import com.example.E_commerce.dtos.CategoryResponseDto;
import com.example.E_commerce.dtos.SubCategoryRequestDto;
import com.example.E_commerce.entity.Category;
import com.example.E_commerce.entity.SubCategory;

import java.util.List;

public class CategoryMapper {

    public static CategoryResponseDto toDto(Category category) {
        if (category == null) return null;

        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryName());
        dto.setCategoryDescription(category.getCategoryDescription());
        dto.setCreatedAt(category.getCreatedAt());
        return dto;
    }
    public static Category toEntity(CategoryRequestDto dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setCategoryDescription(dto.getCategoryDescription());
        return category;
    }
}
