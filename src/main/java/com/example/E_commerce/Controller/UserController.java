package com.example.E_commerce.Controller;

import com.example.E_commerce.Dtos.UserResponseDto;
import com.example.E_commerce.Service.UserServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceMain userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(@RequestParam Long userId) {

        try {
            List<UserResponseDto> users = userService.getAllUsers(userId);

            String message = users.isEmpty()
                    ? "No users found"
                    : "Users fetched successfully";

            return ResponseEntity.ok(Map.of(
                    "status", "SUCCESS",
                    "message", message,
                    "data", users
            ));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                    "status", "ERROR",
                    "message", e.getMessage(),
                    "data", null
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "ERROR",
                    "message", "Something went wrong",
                    "data", null
            ));
        }
    }
}