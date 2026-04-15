package com.example.E_commerce.Service;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.ServiceImpl.CategoryServiceImpl;

import java.util.List;

public interface CategoryService {
    ApiResponse<List<CategoryResponseDto>> getAllCategories();

}
