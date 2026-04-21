package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.CategoryRequestDto;
import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Repository.CategoryRepository;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new RuntimeException("Category name cannot be empty");
        }

        if (categoryRepository.existsByCategoryName(dto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setCategoryName(dto.getName());
        category.setCategoryDescription(dto.getDescription());
        category.setUpdatedAt(LocalDateTime.now());
        category.setStatus("ACTIVE");
        category.setActive(true);
        category.setCreatedAt(LocalDateTime.now());

        return mapToDto(categoryRepository.save(category));
    }



    private CategoryResponseDto mapToDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getCategoryName());
        dto.setDescription(category.getCategoryDescription());
        dto.setCreatedAt(category.getCreatedAt());
        return dto;
    }
}