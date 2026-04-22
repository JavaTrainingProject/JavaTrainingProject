package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Service.SubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    private final SubCategoryService service;

    public SubCategoryController(SubCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubCategoryRequestDto dto) {
        try {
            return ResponseEntity.ok(service.createSubCategory(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}