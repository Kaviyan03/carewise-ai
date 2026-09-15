package com.carewise.user.controller;

import java.util.List;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carewise.user.dto.UserRequestDTO;
import com.carewise.user.dto.UserResponseDTO;
import com.carewise.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping
//    public ResponseEntity<UserResponseDTO> createUser(
//            @Valid @RequestBody UserRequestDTO userRequestDTO) {
//
//        UserResponseDTO createdUser =
//                userService.createUser(userRequestDTO);
//
//        return new ResponseEntity<>(
//                createdUser,
//                HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(
            @PathVariable Long id) {

        UserResponseDTO user =
                userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {

        List<UserResponseDTO> users =
                userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO userRequestDTO) {

        UserResponseDTO updatedUser =
                userService.updateUser(id, userRequestDTO);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok(
                "User deleted successfully");
    }
}