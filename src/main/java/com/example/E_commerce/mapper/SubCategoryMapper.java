package com.example.E_commerce.mapper;

import com.example.E_commerce.dtos.SubCategoryRequestDto;
import com.example.E_commerce.dtos.SubCategoryResponseDto;
import com.example.E_commerce.entity.SubCategory;

public class SubCategoryMapper {
    public static SubCategoryResponseDto toDto(SubCategory sub){
        SubCategoryResponseDto dto = new SubCategoryResponseDto();
        dto.setId(sub.getId());
        dto.setSubCategoryName(sub.getSubCategoryName());
        dto.setSubCategoryDescription(sub.getSubCategoryDescription());

        if (sub.getCategory() != null) {
            dto.setCategoryId(sub.getCategory().getId());
            dto.setCategoryName(sub.getCategory().getCategoryName());
        }
        return dto;
    }

    public SubCategory ToEntity (SubCategoryRequestDto dto){
        SubCategory sub = new SubCategory();
        sub.setSubCategoryName(dto.getSubCategoryname());
        sub.setSubCategoryDescription(dto.getSubCategorydescription());
        return sub;
    }
}
