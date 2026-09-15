package com.carewise.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carewise.auth.dto.LoginRequestDTO;
import com.carewise.auth.dto.LoginResponseDTO;
import com.carewise.auth.service.AuthService;
import com.carewise.exception.DuplicateResourceException;
import com.carewise.security.JwtService;
import com.carewise.user.dto.UserRequestDTO;
import com.carewise.user.dto.UserResponseDTO;
import com.carewise.user.entity.User;
import com.carewise.user.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	public AuthServiceImpl(UserRepository userRepository,
	            PasswordEncoder passwordEncoder,
	            JwtService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO request) {

	    User user = userRepository.findByEmail(request.getEmail())
	            .orElseThrow(() ->
	                    new RuntimeException(
	                            "User not found"));

	    boolean passwordMatches =
	            passwordEncoder.matches(
	                    request.getPassword(),
	                    user.getPassword());

	    if (!passwordMatches) {
	        throw new RuntimeException(
	                "Invalid email or password");
	    }

	    String token =
	            jwtService.generateToken(
	                    user.getEmail());

	    return new LoginResponseDTO(token);
	}

	@Override
	public UserResponseDTO register(UserRequestDTO userRequestDTO) {
		if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new DuplicateResourceException(
                    "User already exists with email: "
                            + userRequestDTO.getEmail());
        }

        User user = new User();

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(
                passwordEncoder.encode(
                        userRequestDTO.getPassword()
                )
        );
        user.setRole("USER");
        user.setAge(userRequestDTO.getAge());
        user.setGender(userRequestDTO.getGender());

        User savedUser = userRepository.save(user);

        return convertToResponseDTO(savedUser);
	}
	
	private UserResponseDTO convertToResponseDTO(User user) {

        UserResponseDTO responseDTO = new UserResponseDTO();

        responseDTO.setId(user.getId());
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setRole(user.getRole());
        responseDTO.setAge(user.getAge());
        responseDTO.setGender(user.getGender());
        responseDTO.setCreatedAt(user.getCreatedAt());

        return responseDTO;
    }
}
