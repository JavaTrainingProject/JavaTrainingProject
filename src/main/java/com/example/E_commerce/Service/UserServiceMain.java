package com.example.E_commerce.Service;

import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Enum.Role;
import org.springframework.stereotype.Service;


public interface UserServiceMain {
    UserResponseDto getUserById(Long id, Long loggedInUserId, Role role);
}
