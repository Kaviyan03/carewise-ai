package com.carewise.user.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.carewise.exception.DuplicateResourceException;
import com.carewise.exception.ResourceNotFoundException;
import com.carewise.user.dto.UserRequestDTO;
import com.carewise.user.dto.UserResponseDTO;
import com.carewise.user.entity.User;
import com.carewise.user.repository.UserRepository;
import com.carewise.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
//
//        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
//            throw new DuplicateResourceException(
//                    "User already exists with email: "
//                            + userRequestDTO.getEmail());
//        }
//
//        User user = new User();
//
//        user.setFirstName(userRequestDTO.getFirstName());
//        user.setLastName(userRequestDTO.getLastName());
//        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(
//                passwordEncoder.encode(
//                        userRequestDTO.getPassword()
//                )
//        );
//        user.setAge(userRequestDTO.getAge());
//        user.setGender(userRequestDTO.getGender());
//
//        User savedUser = userRepository.save(user);
//
//        return convertToResponseDTO(savedUser);
//    }

    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        return convertToResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(
                passwordEncoder.encode(
                        userRequestDTO.getPassword()
                )
        );
        user.setAge(userRequestDTO.getAge());
        user.setGender(userRequestDTO.getGender());

        User updatedUser = userRepository.save(user);

        return convertToResponseDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        userRepository.delete(user);
    }

    private UserResponseDTO convertToResponseDTO(User user) {

        UserResponseDTO responseDTO = new UserResponseDTO();

        responseDTO.setId(user.getId());
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setAge(user.getAge());
        responseDTO.setGender(user.getGender());
        responseDTO.setCreatedAt(user.getCreatedAt());

        return responseDTO;
    }
}