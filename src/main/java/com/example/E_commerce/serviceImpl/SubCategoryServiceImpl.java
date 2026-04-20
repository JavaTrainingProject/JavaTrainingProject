package com.example.E_commerce.serviceImpl;

import com.example.E_commerce.ApiResponse;
import com.example.E_commerce.dtos.SubCategoryResponseDto;
import com.example.E_commerce.entity.SubCategory;
import com.example.E_commerce.enums.Status;
import com.example.E_commerce.mapper.SubCategoryMapper;
import com.example.E_commerce.repository.SubCategoryRepository;
import com.example.E_commerce.service.SubCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public SubCategoryResponseDto getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found with id: " + id));

        return SubCategoryMapper.toDto(subCategory);
    }

    @Override
    public ApiResponse<List<SubCategoryResponseDto>> getAllActiveSubCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Page<SubCategory> subCategoryPage = subCategoryRepository.findByStatus(Status.ACTIVE,pageable);

        List<SubCategoryResponseDto> responseList = subCategoryPage.getContent()
                .stream()
                .map(SubCategoryMapper::toDto) // static mapper
                .toList();

        return new ApiResponse<>(
                "Active subcategories fetched successfully",true,responseList
        );
    }
}

