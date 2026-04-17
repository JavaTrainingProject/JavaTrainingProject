package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.UserRequestDTO;
import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Dtos.UserUpdateRequestDTO;
import com.example.E_commerce.Enum.Role;
import org.springframework.stereotype.Service;


public interface UserServiceMain {

    UserResponseDto registerUser(UserRequestDTO dto);

    UserResponseDto registerAdmin(UserRequestDTO dto);
    UserResponseDto updateUser(Long id, UserUpdateRequestDTO dto);

    UserResponseDto getUserById(Long id, Long loggedInUserId, Role role);
    void deleteUser(Long id);
}
