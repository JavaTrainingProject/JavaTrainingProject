package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity.Product;
import com.example.E_commerce.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
