package com.example.E_commerce.Controller;

import com.example.E_commerce.Entity.LoginRequestDtos;
import com.example.E_commerce.Entity.SignupRequestDtos;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceMain userService;

    // USER SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDtos request) {
        return userService.registerUser(request);
    }

    // ADMIN REGISTER
    @PostMapping("/adminRegister")
    public String registerAdmin(@RequestBody SignupRequestDtos request) {
        return userService.registerAdmin(request);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDtos request) {
        return userService.login(request);
    }
}
