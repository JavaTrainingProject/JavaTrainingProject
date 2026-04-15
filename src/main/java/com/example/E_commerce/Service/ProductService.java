package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.ProductRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    String createProduct(ProductRequestDto dto, List<MultipartFile> images);
}
