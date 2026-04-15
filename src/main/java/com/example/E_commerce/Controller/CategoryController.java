package com.example.E_commerce.Controller;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories(){
        ApiResponse<List<CategoryResponseDto>> response=categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }




}
