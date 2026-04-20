package com.example.E_commerce.controller;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.SubCategoryResponseDto;
import com.example.E_commerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/SubCategory")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryResponseDto> getSubCategoryById(@PathVariable Long id) {
        SubCategoryResponseDto dto = subCategoryService.getSubCategoryById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<SubCategoryResponseDto>>> getActiveSubCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(subCategoryService.getAllActiveSubCategories(page, size));
    }

}
