package com.carewise.wellness.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.carewise.exception.DuplicateResourceException;
import com.carewise.exception.ResourceNotFoundException;
import com.carewise.user.entity.User;
import com.carewise.user.repository.UserRepository;
import com.carewise.wellness.dto.WellnessLogRequestDTO;
import com.carewise.wellness.dto.WellnessLogResponseDTO;
import com.carewise.wellness.entity.WellnessLog;
import com.carewise.wellness.repository.WellnessLogRepository;
import com.carewise.wellness.service.WellnessLogService;

@Service
public class WellnessLogServiceImpl implements WellnessLogService {

    private final WellnessLogRepository wellnessLogRepository;
    private final UserRepository userRepository;

    public WellnessLogServiceImpl(
            WellnessLogRepository wellnessLogRepository,
            UserRepository userRepository) {

        this.wellnessLogRepository = wellnessLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public WellnessLogResponseDTO createWellnessLog(
            WellnessLogRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: "
                                        + requestDTO.getUserId()));
        
        if (wellnessLogRepository.existsByUserIdAndLogDate(
                requestDTO.getUserId(),
                requestDTO.getLogDate())) {

            throw new DuplicateResourceException(
                    "Wellness log already exists for user id: "
                            + requestDTO.getUserId()
                            + " on date: "
                            + requestDTO.getLogDate());
        }

        WellnessLog wellnessLog = new WellnessLog();

        wellnessLog.setSteps(requestDTO.getSteps());
        wellnessLog.setWaterIntake(requestDTO.getWaterIntake());
        wellnessLog.setSleepHours(requestDTO.getSleepHours());
        wellnessLog.setExerciseMinutes(
                requestDTO.getExerciseMinutes());
        wellnessLog.setLogDate(requestDTO.getLogDate());
        wellnessLog.setUser(user);

        WellnessLog savedWellnessLog =
                wellnessLogRepository.save(wellnessLog);

        return convertToResponseDTO(savedWellnessLog);
    }

    @Override
    public WellnessLogResponseDTO getWellnessLogById(Long id) {

        WellnessLog wellnessLog =
                wellnessLogRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Wellness log not found with id: "
                                                + id));

        return convertToResponseDTO(wellnessLog);
    }

    @Override
    public List<WellnessLogResponseDTO> getAllWellnessLogs() {

        List<WellnessLog> wellnessLogs =
                wellnessLogRepository.findAll();

        return wellnessLogs.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WellnessLogResponseDTO> getWellnessLogsByUserId(
            Long userId) {

        /*
         * First verify that the user exists.
         * This distinguishes between:
         *
         * 1. User does not exist
         * 2. User exists but has no wellness logs
         */
        userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + userId));

        List<WellnessLog> wellnessLogs =
                wellnessLogRepository.findByUserId(userId);

        return wellnessLogs.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WellnessLogResponseDTO updateWellnessLog(
            Long id,
            WellnessLogRequestDTO requestDTO) {

        WellnessLog wellnessLog =
                wellnessLogRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Wellness log not found with id: "
                                                + id));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: "
                                        + requestDTO.getUserId()));

        wellnessLog.setSteps(requestDTO.getSteps());
        wellnessLog.setWaterIntake(requestDTO.getWaterIntake());
        wellnessLog.setSleepHours(requestDTO.getSleepHours());
        wellnessLog.setExerciseMinutes(
                requestDTO.getExerciseMinutes());
        wellnessLog.setLogDate(requestDTO.getLogDate());
        wellnessLog.setUser(user);

        WellnessLog updatedWellnessLog =
                wellnessLogRepository.save(wellnessLog);

        return convertToResponseDTO(updatedWellnessLog);
    }

    @Override
    public void deleteWellnessLog(Long id) {

        WellnessLog wellnessLog =
                wellnessLogRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Wellness log not found with id: "
                                                + id));

        wellnessLogRepository.delete(wellnessLog);
    }

    private WellnessLogResponseDTO convertToResponseDTO(
            WellnessLog wellnessLog) {

        WellnessLogResponseDTO responseDTO =
                new WellnessLogResponseDTO();

        responseDTO.setId(wellnessLog.getId());
        responseDTO.setSteps(wellnessLog.getSteps());
        responseDTO.setWaterIntake(
                wellnessLog.getWaterIntake());
        responseDTO.setSleepHours(
                wellnessLog.getSleepHours());
        responseDTO.setExerciseMinutes(
                wellnessLog.getExerciseMinutes());
        responseDTO.setLogDate(wellnessLog.getLogDate());
        responseDTO.setUserId(wellnessLog.getUser().getId());

        return responseDTO;
    }
}