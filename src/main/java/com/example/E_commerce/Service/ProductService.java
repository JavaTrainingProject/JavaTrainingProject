package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.ProductRequestDto;
import com.example.E_commerce.Dtos.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

        ProductResponseDto createProduct(ProductRequestDto dto, List<MultipartFile> images);

        Page<ProductResponseDto> getAllProducts(int page, int size);

        ProductResponseDto updateProduct(Long id, ProductRequestDto dto, List<MultipartFile> images, List<String> removeImages);
    }
