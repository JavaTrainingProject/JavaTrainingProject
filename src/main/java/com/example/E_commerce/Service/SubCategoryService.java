package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Dtos.SubCategoryResponseDto;

public interface SubCategoryService {
    SubCategoryResponseDto createSubCategory(SubCategoryRequestDto dto);
}