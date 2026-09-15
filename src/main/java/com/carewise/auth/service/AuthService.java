package com.carewise.auth.service;

import com.carewise.auth.dto.LoginRequestDTO;
import com.carewise.auth.dto.LoginResponseDTO;
import com.carewise.user.dto.UserRequestDTO;
import com.carewise.user.dto.UserResponseDTO;

public interface AuthService {
	
	LoginResponseDTO login(LoginRequestDTO request);
	
	UserResponseDTO register(UserRequestDTO request);
}
