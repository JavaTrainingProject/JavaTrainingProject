package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.ProductRequestDto;
import com.example.E_commerce.Dtos.ProductResponseDto;
import com.example.E_commerce.Entity.Product;
import com.example.E_commerce.Entity.ProductImage;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Repository.ProductRepository;
import com.example.E_commerce.Repository.SubCategoryRepository;
import com.example.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private SubCategoryRepository subCategoryRepository;

        //  CREATE PRODUCT
        @Override
        public String createProduct(ProductRequestDto dto, List<MultipartFile> images) {

            SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));

            Product product = new Product();
            product.setProductName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            product.setImageFile(dto.getImageFile());
            product.setSubCategory(subCategory);
            product.setCreatedAt(LocalDateTime.now());

            //  Handle images (optional)
            if (images != null && !images.isEmpty()) {
                List<ProductImage> imageList = new ArrayList<>();

                for (MultipartFile file : images) {
                    ProductImage img = new ProductImage();

                    String fileName = file.getOriginalFilename(); // simple storage
                    img.setImageFile(fileName);

                    img.setProduct(product);
                    imageList.add(img);
                }

                product.setImages(imageList);
            }

            productRepository.save(product);

            return "Product Created Successfully";
        }

        //  GET ALL (LIST)
        @Override
        public List<ProductResponseDto> getAllProducts() {
            return productRepository.findAll()
                    .stream()
                    .map(this::mapToDto)
                    .toList();
        }

        //  GET ALL (PAGINATION)
        @Override
        public Page<ProductResponseDto> getAllProducts(int page, int size) {

            Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

            return productRepository.findAll(pageable)
                    .map(this::mapToDto);
        }

        //  COMMON MAPPER
        private ProductResponseDto mapToDto(Product product) {

            ProductResponseDto dto = new ProductResponseDto();

            dto.setId(product.getId());
            dto.setName(product.getProductName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setQuantity(product.getQuantity());
            dto.setImageFile(product.getImageFile());
            dto.setCreatedAt(product.getCreatedAt());

            //  SubCategory safe mapping
            if (product.getSubCategory() != null) {
                dto.setSubCategoryName(product.getSubCategory().getSubCategoryName());
            } else {
                dto.setSubCategoryName("N/A");
            }

            //  Static category (you didn’t map relation yet)
            dto.setCategoryName("Default Category");

            return dto;
        }

    @Override
    public String updateProduct(Long id, ProductRequestDto dto, List<MultipartFile> images) {

        //  Find existing product
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        //  Update fields
        product.setProductName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        //  Update SubCategory
        if (dto.getSubCategoryId() != null) {
            SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));

            product.setSubCategory(subCategory);
        }

        product.setUpdatedAt(LocalDateTime.now());

        //  Update Images (optional)
        if (images != null && !images.isEmpty()) {

            List<ProductImage> imageList = new ArrayList<>();

            for (MultipartFile file : images) {
                ProductImage img = new ProductImage();

                String fileName = file.getOriginalFilename();
                img.setImageFile(fileName);

                img.setProduct(product);
                imageList.add(img);
            }

            product.setImages(imageList);
        }

        productRepository.save(product);

        return "Product Updated Successfully";
    }

    }