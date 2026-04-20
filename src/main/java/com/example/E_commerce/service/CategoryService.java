package com.example.E_commerce.service;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    ApiResponse<List<CategoryResponseDto>> getAllCategories(int page, int size);


}
