package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.UserRequestDTO;
import com.example.E_commerce.Dtos.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServiceMain {

    UserResponseDto registerUser(UserRequestDTO dto);

    UserResponseDto registerAdmin(UserRequestDTO dto);

    Page<UserResponseDto> getAllUsers(Pageable pageable);
}