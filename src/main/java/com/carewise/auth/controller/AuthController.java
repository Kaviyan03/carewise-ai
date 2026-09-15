package com.carewise.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carewise.auth.dto.LoginRequestDTO;
import com.carewise.auth.dto.LoginResponseDTO;
import com.carewise.auth.service.AuthService;
import com.carewise.user.dto.UserRequestDTO;
import com.carewise.user.dto.UserResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @Valid
            @RequestBody UserRequestDTO request) {

        UserResponseDTO response =
                authService.register(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request) {

        LoginResponseDTO response =
                authService.login(request);

        return ResponseEntity.ok(response);
    }
}