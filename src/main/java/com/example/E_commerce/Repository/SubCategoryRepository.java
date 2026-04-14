package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    List<SubCategory> findAllById(Long id);

}
