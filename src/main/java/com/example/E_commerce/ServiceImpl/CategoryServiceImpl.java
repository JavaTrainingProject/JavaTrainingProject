package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.CategoryResponseDto;
import com.example.E_commerce.Dtos.ProductResponseDto;
import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Enum.Status;
import com.example.E_commerce.Repository.CategoryRepository;
import com.example.E_commerce.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {

        if (id == null || id <= 0) {
            throw new RuntimeException("Invalid category ID");
        }

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        return mapToDto(category);
    }

    @Override
    public List<CategoryResponseDto> getActiveCategories() {

        List<Category> categories = repository.findByStatus("ACTIVE");

        return categories.stream()
                .map(this::mapToDto)
                .toList();
    }

    private CategoryResponseDto mapToDto(Category category) {

        CategoryResponseDto dto = new CategoryResponseDto();

        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        dto.setStatus(category.getStatus() != null ? category.getStatus() : "INACTIVE");

        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());

        return dto;
    }
    @Override
    public List<CategoryResponseDto> getActiveCategoriesWithProducts() {

        List<Category> categories = repository.findByStatus("ACTIVE");

        return categories.stream()
                .map(category -> {

                    List<ProductResponseDto> activeProducts = category.getProducts()
                            .stream()
                            .filter(p -> p.getStatus() != null && p.getStatus() == Status.ACTIVE)                            .map(p -> {
                                ProductResponseDto dto = new ProductResponseDto();
                                dto.setId(p.getId());
                                dto.setName(p.getProductName());
                                dto.setDescription(p.getDescription());
                                dto.setPrice(p.getPrice());
                                return dto;
                            })
                            .toList();

                    if (activeProducts.isEmpty()) {
                        return null;
                    }

                    CategoryResponseDto dto = new CategoryResponseDto();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setDescription(category.getDescription());
                    dto.setStatus(category.getStatus());
                    dto.setProducts(activeProducts);

                    return dto;
                })
                .filter(c -> c != null)
                .toList();
    }
}