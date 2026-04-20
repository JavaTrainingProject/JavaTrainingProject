package com.example.E_commerce.repository;

import com.example.E_commerce.entity.SubCategory;
import com.example.E_commerce.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    Page<SubCategory> findByStatus(Status status, Pageable pageable);

}
