package com.example.E_commerce.Controller;


import com.example.E_commerce.Dtos.*;
import com.example.E_commerce.Service.UserServiceMain;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class RegisterController {


    @Autowired
    private UserServiceMain userService;

    @PostMapping("/user")
    public UserResponseDto registerUser(@Valid @RequestBody UserRequestDTO dto) {
        return userService.registerUser(dto);
    }

    @PostMapping("/register")
    public UserResponseDto registerAdmin(@Valid @RequestBody UserRequestDTO dto) {
        return userService.registerAdmin(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        return userService.login(dto);
    }


    @PostMapping("/refreshToken")
    public LoginResponseDTO refreshToken(@Valid @RequestBody RefreshRequestDTO dto) {
        return userService.refreshToken(dto);
    }
}
