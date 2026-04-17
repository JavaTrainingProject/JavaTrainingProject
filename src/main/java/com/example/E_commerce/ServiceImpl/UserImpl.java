package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.Dtos.*;
import com.example.E_commerce.Entity.RefreshToken;
import com.example.E_commerce.Entity.UserEntity;
import com.example.E_commerce.Enum.Role;
import com.example.E_commerce.Repository.UserRepository;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserImpl implements UserServiceMain {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    public UserResponseDto registerUser(UserRequestDTO dto){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        return saveUser(dto,Role.USER);

}

public UserResponseDto registerAdmin(UserRequestDTO dto){

        if(userRepository.findByRole(Role.ADMIN).isPresent()){
            throw new RuntimeException("Admin already exists");
        }

        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        return saveUser(dto,Role.ADMIN);

}

private UserResponseDto saveUser(UserRequestDTO dto,Role role){
    UserEntity user=new UserEntity();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    user.setRole(role);
    user.setCreatedAt(LocalDateTime.now());

    UserEntity savedUser=userRepository.save(user);
    return mapToResponse(savedUser);
}

private UserResponseDto mapToResponse(UserEntity user){
        UserResponseDto response=new UserResponseDto();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        return response;
}

public LoginResponseDTO login(LoginRequestDTO dto){

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    dto.getEmail(),
                    dto.getPassword()
            )
    );

       UserEntity user=userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));

        String token=jwtService.generateToken(user.getEmail(),user.getRole());

        RefreshToken refreshToken=refreshTokenService.createRefreshToken(user.getEmail());

        LoginResponseDTO response=new LoginResponseDTO();
        response.setToken(token);
        response.setRefreshToken(refreshToken.getRefreshToken());
        response.setId(user.getId());
        response.setRole(user.getRole());
        return response;
    }

    public LoginResponseDTO refreshToken(RefreshRequestDTO dto){
        RefreshToken refreshToken=refreshTokenService.verifyRefreshToken(dto.getRefreshToken());

        UserEntity user=refreshToken.getUser();

        String newAccessToken=jwtService.generateToken(user.getEmail(),user.getRole());

        LoginResponseDTO response=new LoginResponseDTO();
        response.setToken(newAccessToken);
        response.setRefreshToken(refreshToken.getRefreshToken());
        response.setId(user.getId());
        response.setRole(user.getRole());

        return response;
    }
}

