package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Dtos.SubCategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Repository.SubCategoryRepository;
import com.example.E_commerce.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategoryResponseDto getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + id));

        SubCategoryResponseDto dto = new SubCategoryResponseDto();
        dto.setId(subCategory.getId());
        dto.setName(subCategory.getName());
        dto.setDescription(subCategory.getDescription());
        return dto;
    }

    @Override
    public SubCategoryResponseDto addSubCategory(SubCategoryRequestDto dto) {
        SubCategory subCategory = new SubCategory();
        subCategory.setName(dto.getName());
        subCategory.setDescription(dto.getDescription());

        SubCategory saved = subCategoryRepository.save(subCategory);

        SubCategoryResponseDto response = new SubCategoryResponseDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());

        return response;
    }

    public SubCategoryResponseDto mapToSubCategoryDto(SubCategory sub) {
        SubCategoryResponseDto dto = new SubCategoryResponseDto();
        dto.setId(sub.getId());
        dto.setName(sub.getName());
        dto.setDescription(sub.getDescription());
        return dto;
    }

    public SubCategory mapToEntity(SubCategoryRequestDto dto) {
        SubCategory sub = new SubCategory();
        sub.setName(dto.getName());
        sub.setDescription(dto.getDescription());
        return sub;
    }
}

