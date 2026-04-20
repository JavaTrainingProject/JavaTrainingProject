package com.example.E_commerce.service;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.SubCategoryRequestDto;
import com.example.E_commerce.dtos.SubCategoryResponseDto;
import com.example.E_commerce.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    SubCategoryResponseDto getSubCategoryById(Long id);

    ApiResponse<List<SubCategoryResponseDto>> getAllActiveSubCategories (int page, int size);




}
