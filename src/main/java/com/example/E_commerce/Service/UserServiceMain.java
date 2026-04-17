package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


public interface UserServiceMain {

    UserResponseDto registerUser(UserRequestDTO dto);

    UserResponseDto registerAdmin(UserRequestDTO dto);

    LoginResponseDTO refreshToken(RefreshRequestDTO dto);

    LoginResponseDTO login(@Valid LoginRequestDTO dto);
}
