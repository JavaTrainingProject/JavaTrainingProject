package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.UserRequestDTO;
import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.Enum.Role;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserImpl implements UserServiceMain {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDto registerUser(UserRequestDTO dto){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        UserEntity user=new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        user.setCreatedAt(LocalDateTime.now());

        UserEntity savedUser=userRepository.save(user);

        UserResponseDto response=new UserResponseDto();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;

}
}

