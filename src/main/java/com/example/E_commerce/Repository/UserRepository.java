package com.example.E_commerce.Repository;


import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByRole(Role role);
    boolean existsByEmail(String email);
}