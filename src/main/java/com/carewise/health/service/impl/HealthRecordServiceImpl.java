package com.carewise.health.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.carewise.exception.DuplicateResourceException;
import com.carewise.exception.ResourceNotFoundException;
import com.carewise.health.dto.HealthRecordRequestDTO;
import com.carewise.health.dto.HealthRecordResponseDTO;
import com.carewise.health.entity.HealthRecord;
import com.carewise.health.repository.HealthRecordRepository;
import com.carewise.health.service.HealthRecordService;
import com.carewise.user.entity.User;
import com.carewise.user.repository.UserRepository;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

    private final HealthRecordRepository healthRecordRepository;
    private final UserRepository userRepository;

    public HealthRecordServiceImpl(
            HealthRecordRepository healthRecordRepository,
            UserRepository userRepository) {

        this.healthRecordRepository = healthRecordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public HealthRecordResponseDTO createHealthRecord(
            HealthRecordRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: "
                                        + requestDTO.getUserId()));

        if (healthRecordRepository.existsByUserId(
                requestDTO.getUserId())) {

            throw new DuplicateResourceException(
                    "Health record already exists for user id: "
                            + requestDTO.getUserId());
        }

        HealthRecord healthRecord = new HealthRecord();

        healthRecord.setHeight(requestDTO.getHeight());
        healthRecord.setWeight(requestDTO.getWeight());
        healthRecord.setBloodGroup(requestDTO.getBloodGroup());
        healthRecord.setAllergies(requestDTO.getAllergies());
        healthRecord.setMedicalConditions(
                requestDTO.getMedicalConditions());
        healthRecord.setUser(user);

        HealthRecord savedHealthRecord =
                healthRecordRepository.save(healthRecord);

        return convertToResponseDTO(savedHealthRecord);
    }

    @Override
    public HealthRecordResponseDTO getHealthRecordById(Long id) {

        HealthRecord healthRecord =
                healthRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Health record not found with id: "
                                                + id));

        return convertToResponseDTO(healthRecord);
    }

    @Override
    public HealthRecordResponseDTO getHealthRecordByUserId(
            Long userId) {

        HealthRecord healthRecord =
                healthRecordRepository.findByUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Health record not found for user id: "
                                                + userId));

        return convertToResponseDTO(healthRecord);
    }

    @Override
    public List<HealthRecordResponseDTO> getAllHealthRecords() {

        List<HealthRecord> healthRecords =
                healthRecordRepository.findAll();

        return healthRecords.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HealthRecordResponseDTO updateHealthRecord(
            Long id,
            HealthRecordRequestDTO requestDTO) {

        HealthRecord healthRecord =
                healthRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Health record not found with id: "
                                                + id));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: "
                                        + requestDTO.getUserId()));

        /*
         * Check whether the userId is being changed.
         * If it is changed, ensure the new user does not already
         * have another health record.
         */
        Long currentUserId = healthRecord.getUser().getId();
        Long requestedUserId = requestDTO.getUserId();

        if (!currentUserId.equals(requestedUserId)
                && healthRecordRepository.existsByUserId(
                        requestedUserId)) {

            throw new DuplicateResourceException(
                    "Health record already exists for user id: "
                            + requestedUserId);
        }

        healthRecord.setHeight(requestDTO.getHeight());
        healthRecord.setWeight(requestDTO.getWeight());
        healthRecord.setBloodGroup(requestDTO.getBloodGroup());
        healthRecord.setAllergies(requestDTO.getAllergies());
        healthRecord.setMedicalConditions(
                requestDTO.getMedicalConditions());
        healthRecord.setUser(user);

        HealthRecord updatedHealthRecord =
                healthRecordRepository.save(healthRecord);

        return convertToResponseDTO(updatedHealthRecord);
    }

    @Override
    public void deleteHealthRecord(Long id) {

        HealthRecord healthRecord =
                healthRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Health record not found with id: "
                                                + id));

        healthRecordRepository.delete(healthRecord);
    }

    private HealthRecordResponseDTO convertToResponseDTO(
            HealthRecord healthRecord) {

        HealthRecordResponseDTO responseDTO =
                new HealthRecordResponseDTO();

        responseDTO.setId(healthRecord.getId());
        responseDTO.setHeight(healthRecord.getHeight());
        responseDTO.setWeight(healthRecord.getWeight());
        responseDTO.setBloodGroup(healthRecord.getBloodGroup());
        responseDTO.setAllergies(healthRecord.getAllergies());
        responseDTO.setMedicalConditions(
                healthRecord.getMedicalConditions());
        responseDTO.setUserId(healthRecord.getUser().getId());

        return responseDTO;
    }
}