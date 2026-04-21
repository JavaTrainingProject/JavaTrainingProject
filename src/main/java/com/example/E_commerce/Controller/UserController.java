package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceMain userService;

    public UserController(UserServiceMain userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }
}