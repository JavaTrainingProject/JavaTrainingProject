package com.example.E_commerce.serviceImpl;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.CategoryResponseDto;
import com.example.E_commerce.entity.Category;
import com.example.E_commerce.mapper.CategoryMapper;
import com.example.E_commerce.repository.CategoryRepository;
import com.example.E_commerce.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiResponse<List<CategoryResponseDto>> getAllCategories(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<CategoryResponseDto> responseList = categoryPage.getContent()
                .stream()
                .map(CategoryMapper::toDto)
                .toList();

        return new ApiResponse<>(
                "Categories fetched successfully",true,responseList
        );
    }
}






