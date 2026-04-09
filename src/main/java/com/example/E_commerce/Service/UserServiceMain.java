package com.example.E_commerce.Service;

import com.example.E_commerce.Entity.LoginRequestDtos;
import com.example.E_commerce.Entity.SignupRequestDtos;
import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.ServiceImpl.UserImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserServiceMain {
    String registerUser(SignupRequestDtos request);
    String registerAdmin(SignupRequestDtos request);
    String login(LoginRequestDtos request);
}
