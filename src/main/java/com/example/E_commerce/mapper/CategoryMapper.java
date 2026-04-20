package com.example.E_commerce.mapper;

import com.example.E_commerce.dtos.CategoryRequestDto;
import com.example.E_commerce.dtos.CategoryResponseDto;
import com.example.E_commerce.entity.Category;

public class CategoryMapper {

    public static CategoryResponseDto toDto(Category category) {
        if (category == null) return null;

        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setCategoryname(category.getCategoryName());
        dto.setCategorydescription(category.getCategoryDescription());

        return dto;
    }

    public Category toEntity(CategoryRequestDto dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setCategoryName(dto.getCategoryname());
        category.setCategoryDescription(dto.getCategorydescription());

        return category;
    }
}
