package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Dtos.SubCategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Enum.Status;
import com.example.E_commerce.Repository.CategoryRepository;
import com.example.E_commerce.Repository.SubCategoryRepository;
import com.example.E_commerce.Service.SubCategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository,
                                  CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SubCategoryResponseDto createSubCategory(SubCategoryRequestDto dto) {

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new RuntimeException("Subcategory name is required");
        }

        if (dto.getCategoryId() == null) {
            throw new RuntimeException("Category ID is required");
        }
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Invalid categoryId: Category not found"));

        if (subCategoryRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new RuntimeException("Subcategory already exists");
        }

        SubCategory subCategory = new SubCategory();
        subCategory.setName(dto.getName());
        subCategory.setDescription(dto.getDescription());
        subCategory.setCategory(category);
        subCategory.setStatus(Status.ACTIVE);
        subCategory.setCreatedAt(LocalDateTime.now());
        subCategory.setUpdatedAt(LocalDateTime.now());

        SubCategory saved = subCategoryRepository.save(subCategory);

        SubCategoryResponseDto response = new SubCategoryResponseDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setStatus(saved.getStatus());
        response.setCategoryId(saved.getCategory().getId());
        response.setCreatedAt(saved.getCreatedAt());

        return response;
    }
}