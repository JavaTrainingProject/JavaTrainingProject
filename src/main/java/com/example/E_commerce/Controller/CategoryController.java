package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.CategoryRequestDto;
import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto dto) {
        CategoryResponseDto response = categoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getActiveCategoryCount() {
        return ResponseEntity.ok(categoryService.getActiveCategoryCount());
    }
}
