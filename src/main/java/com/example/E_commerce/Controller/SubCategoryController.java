package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.SubCategoryRequestDto;
import com.example.E_commerce.Dtos.SubCategoryResponseDto;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Service.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sub")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/getsub/{id}")
    public ResponseEntity<SubCategoryResponseDto> getSubCategoryById(@PathVariable Long id) {
        SubCategoryResponseDto dto = subCategoryService.getSubCategoryById(id);
        return ResponseEntity.ok(dto);
    }

}
