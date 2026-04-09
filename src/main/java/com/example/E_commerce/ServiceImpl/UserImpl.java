package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Entity.LoginRequestDtos;
import com.example.E_commerce.Entity.Role;
import com.example.E_commerce.Entity.SignupRequestDtos;
import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserServiceMain {
    @Autowired
    private UserRepository userRepository;


    public String registerUser(SignupRequestDtos request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            return "Email already exists!";
        }
        UserEntity user = new UserEntity();
        user.setName(request.username);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setRole(Role.USER);

        userRepository.save(user);
        return "User Registered Successfully";
    }

    public String registerAdmin(SignupRequestDtos request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            return "Email already exists!";
        }

        UserEntity admin = new UserEntity();
        admin.setName(request.username);
        admin.setEmail(request.email);
        admin.setPassword(request.password);
        admin.setRole(Role.ADMIN);

        userRepository.save(admin);
        return "Admin Registered Successfully";
    }

    public String login(LoginRequestDtos request) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(request.email);

        if (userOpt.isEmpty()) {
            return "User not found!";
        }

        UserEntity user = userOpt.get();

        if (!user.getPassword().equals(request.password)) {
            return "Invalid password!";
        }

        return "Login Successful as " + user.getRole();
    }
}

