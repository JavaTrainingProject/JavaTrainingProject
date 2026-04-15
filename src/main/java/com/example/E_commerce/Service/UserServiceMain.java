package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.UserRequestDTO;
import com.example.E_commerce.Dtos.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceMain {

    UserResponseDto registerUser(UserRequestDTO dto);

    UserResponseDto registerAdmin(UserRequestDTO dto);
    List<UserResponseDto> getAllUsers(Long userId);

}
