package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Dtos.SubCategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    SubCategoryResponseDto getSubCategoryById(Long id);

    SubCategoryResponseDto addSubCategory(SubCategoryRequestDto dto);

    SubCategoryResponseDto mapToSubCategoryDto(SubCategory sub);

    SubCategory mapToEntity(SubCategoryRequestDto dto);

}
