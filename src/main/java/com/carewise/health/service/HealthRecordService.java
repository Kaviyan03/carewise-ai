package com.carewise.health.service;

import java.util.List;

import com.carewise.health.dto.HealthRecordRequestDTO;
import com.carewise.health.dto.HealthRecordResponseDTO;

public interface HealthRecordService {

    HealthRecordResponseDTO createHealthRecord(
            HealthRecordRequestDTO requestDTO);

    HealthRecordResponseDTO getHealthRecordById(Long id);

    HealthRecordResponseDTO getHealthRecordByUserId(Long userId);

    List<HealthRecordResponseDTO> getAllHealthRecords();

    HealthRecordResponseDTO updateHealthRecord(
            Long id,
            HealthRecordRequestDTO requestDTO);

    void deleteHealthRecord(Long id);
}