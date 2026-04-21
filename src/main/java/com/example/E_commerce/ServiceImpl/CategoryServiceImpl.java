package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Repository.CategoryRepository;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {

        if (id == null || id <= 0) {
            throw new RuntimeException("Invalid category ID");
        }

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        return mapToDto(category);
    }

    @Override
    public List<CategoryResponseDto> getActiveCategories() {

        List<Category> categories = repository.findByStatus("ACTIVE");

        return categories.stream()
                .map(this::mapToDto)
                .toList();
    }

    private CategoryResponseDto mapToDto(Category category) {

        CategoryResponseDto dto = new CategoryResponseDto();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        dto.setStatus(category.getStatus() != null ? category.getStatus() : "INACTIVE");

        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());

        return dto;
    }
}