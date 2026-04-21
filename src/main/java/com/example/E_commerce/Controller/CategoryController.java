package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }
    @GetMapping("/active")
    public List<CategoryResponseDto> getActiveCategories() {
        return service.getActiveCategories();
    }
}