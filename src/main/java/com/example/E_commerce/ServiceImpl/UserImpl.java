package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements UserServiceMain {
    @Autowired
    private UserRepository userRepository;

}

