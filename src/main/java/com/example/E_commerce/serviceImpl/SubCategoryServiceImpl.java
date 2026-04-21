package com.example.E_commerce.serviceImpl;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.SubCategoryRequestDto;
import com.example.E_commerce.dtos.SubCategoryResponseDto;
import com.example.E_commerce.entity.Category;
import com.example.E_commerce.entity.SubCategory;
import com.example.E_commerce.enums.Status;
import com.example.E_commerce.mapper.SubCategoryMapper;
import com.example.E_commerce.repository.CategoryRepository;
import com.example.E_commerce.repository.SubCategoryRepository;
import com.example.E_commerce.service.SubCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SubCategoryResponseDto getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + id));

        return SubCategoryMapper.toDto(subCategory);
    }

    @Override
    public ApiResponse<List<SubCategoryResponseDto>> getAllActiveSubCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Page<SubCategory> subCategoryPage = subCategoryRepository.findByStatus(Status.ACTIVE,pageable);

        List<SubCategoryResponseDto> responseList = subCategoryPage.getContent()
                .stream()
                .map(SubCategoryMapper::toDto) // static mapper
                .toList();

        return new ApiResponse<>(
                "Active subcategories fetched successfully",true,responseList
        );
    }

    @Override
    public SubCategoryResponseDto updateSubCategory(Long id, SubCategoryRequestDto dto) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + id));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        subCategory.setSubCategoryName(dto.getSubCategoryname());
        subCategory.setSubCategoryDescription(dto.getSubCategorydescription());
        subCategory.setCategory(category);

        SubCategory updated = subCategoryRepository.save(subCategory);

        return SubCategoryMapper.toDto(updated);
    }

}

