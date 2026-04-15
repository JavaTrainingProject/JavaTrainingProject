package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.ProductRequestDto;
import com.example.E_commerce.Entity.Product;
import com.example.E_commerce.Entity.ProductImage;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Repository.ProductRepository;
import com.example.E_commerce.Repository.SubCategoryRepository;
import com.example.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public String createProduct(ProductRequestDto dto, List<MultipartFile> images) {

        System.out.println(dto.getName());
        System.out.println(dto.getDescription());
        System.out.println(dto.getPrice());
        System.out.println(dto.getQuantity());



        // ✅ Validate SubCategory
        SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));

        // ✅ Create Product
        Product product = new Product();
        product.setProductName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setSubCategory(subCategory);


        // ✅ Handle Images (optional)
        if (images != null && !images.isEmpty()) {
            List<ProductImage> imageList = new ArrayList<>();

            for (MultipartFile file : images) {
                ProductImage img = new ProductImage();

                // simple file name (you can use cloudinary later)
                String fileName = file.getOriginalFilename();
                img.setImageUrl(fileName);

                img.setProduct(product);
                imageList.add(img);
            }

            product.setImages(imageList);
        }

        productRepository.save(product);

        return "Product Created Successfully";
    }
}