package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity.Category;
import com.example.E_commerce.Entity.SubCategory;
import com.example.E_commerce.Enum.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

//    boolean existsByNameIgnoreCase(String name);
}