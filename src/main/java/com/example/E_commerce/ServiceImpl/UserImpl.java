package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.Enum.Role;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserImpl implements UserServiceMain {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponseDto getUserById(Long id, Long loggedInUserId, Role role) {


        if (id == null || id <= 0) {
            throw new RuntimeException("Invalid user ID");
        }

        Optional<UserEntity> optionalUser = userRepository.findById(id);


        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }


        if (role != Role.ADMIN && !id.equals(loggedInUserId)) {
            throw new RuntimeException("Unauthorized access");
        }

        UserEntity user = optionalUser.get();


        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }
}

