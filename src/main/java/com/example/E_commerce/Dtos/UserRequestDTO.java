package com.example.E_commerce.Dtos;

import com.example.E_commerce.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UserRequestDTO {


    @NotBlank(message="Name should not be empty")
    private String name;

    @NotBlank(message = "Email should not be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)\\.com$", message = "Email is invalid")
    private String email;

    @NotBlank(message="Password is required")
    @Size(min=6, message="Password must be atleast 6 characters")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
