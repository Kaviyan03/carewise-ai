package com.carewise.wellness.service;

import java.util.List;

import com.carewise.wellness.dto.WellnessLogRequestDTO;
import com.carewise.wellness.dto.WellnessLogResponseDTO;

public interface WellnessLogService {

    WellnessLogResponseDTO createWellnessLog(
            WellnessLogRequestDTO requestDTO);

    WellnessLogResponseDTO getWellnessLogById(Long id);

    List<WellnessLogResponseDTO> getAllWellnessLogs();

    List<WellnessLogResponseDTO> getWellnessLogsByUserId(Long userId);

    WellnessLogResponseDTO updateWellnessLog(
            Long id,
            WellnessLogRequestDTO requestDTO);

    void deleteWellnessLog(Long id);
}