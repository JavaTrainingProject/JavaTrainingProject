package com.example.E_commerce.Controller;


import com.example.E_commerce.Dtos.ProductRequestDto;
import com.example.E_commerce.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(
            @RequestPart("data") String data,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ProductRequestDto dto = mapper.readValue(data, ProductRequestDto.class);

        return ResponseEntity.ok(productService.createProduct(dto, images));
    }



}


