package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.ProductRequestDto;
import com.example.E_commerce.Dtos.ProductResponseDto;
import com.example.E_commerce.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

        @Autowired
        private ProductService productService;

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<String> createProduct(
            @RequestPart("product") String productJson,
            @RequestPart(value = "images", required = false) List<MultipartFile> images) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ProductRequestDto dto = mapper.readValue(productJson, ProductRequestDto.class);

        productService.createProduct(dto, images);
        return ResponseEntity.ok("Product Created Successfully");
    }

        //  GET ALL (LIST)
        @GetMapping("/all")
        public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
            return ResponseEntity.ok(productService.getAllProducts());
        }

        //  GET ALL (PAGINATION)
        @GetMapping
        public ResponseEntity<Page<ProductResponseDto>> getAllProducts(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "5") int size) {

            return ResponseEntity.ok(productService.getAllProducts(page, size));
        }


        //for updating product

    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long id,
            @ModelAttribute ProductRequestDto dto,
            @RequestParam(value = "images", required = false) List<MultipartFile> images) {

        productService.updateProduct(id, dto, images);
        return ResponseEntity.ok("Product Updated Successfully");
    }
    }