package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Repository.CategoryRepository;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;


    @Override
    public ApiResponse<List<CategoryResponseDto>> getAllCategories() {
        List<Category> categories= categoryRepository.findAll();
       List<CategoryResponseDto> dtoList=categories.stream().map(category -> {
           CategoryResponseDto dto=new CategoryResponseDto();
           dto.setId(category.getId());
           dto.setName(category.getCategoryName());
           dto.setDescription(category.getCategoryDescription());
           dto.setCreatedAt(category.getCreatedAt());
           return dto;
       }).toList();
       if (dtoList.isEmpty()){
           return new ApiResponse<>("Success","Not found",dtoList);
       }
       return  new ApiResponse<>("Success","successfully",dtoList);
    }

}
