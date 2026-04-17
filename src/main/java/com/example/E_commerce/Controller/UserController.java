package com.example.E_commerce.Controller;


import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Dtos.UserUpdateRequestDTO;
import com.example.E_commerce.Enum.Role;
import com.example.E_commerce.Service.UserServiceMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceMain userService;
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable Long id,
            @RequestParam Long loggedInUserId,
            @RequestParam Role role
    ) {
        try {
            UserResponseDto response =
                    userService.getUserById(id, loggedInUserId, role);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/updateUser/{id}")
    public UserResponseDto updateUser(
            @PathVariable Long id,
        @RequestBody UserUpdateRequestDTO dto) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}


