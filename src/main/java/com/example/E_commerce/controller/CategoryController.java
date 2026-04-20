package com.example.E_commerce.controller;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.CategoryResponseDto;
import com.example.E_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/Categories")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                categoryService.getAllCategories(page, size)
        );
    }
}
