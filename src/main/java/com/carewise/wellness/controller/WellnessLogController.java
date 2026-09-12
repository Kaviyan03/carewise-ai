package com.carewise.wellness.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carewise.wellness.dto.WellnessLogRequestDTO;
import com.carewise.wellness.dto.WellnessLogResponseDTO;
import com.carewise.wellness.service.WellnessLogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/wellness-logs")
public class WellnessLogController {

    private final WellnessLogService wellnessLogService;

    public WellnessLogController(
            WellnessLogService wellnessLogService) {

        this.wellnessLogService = wellnessLogService;
    }

    @PostMapping
    public ResponseEntity<WellnessLogResponseDTO> createWellnessLog(
            @Valid @RequestBody WellnessLogRequestDTO requestDTO) {

        WellnessLogResponseDTO responseDTO =
                wellnessLogService.createWellnessLog(requestDTO);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WellnessLogResponseDTO>
            getWellnessLogById(@PathVariable Long id) {

        return ResponseEntity.ok(
                wellnessLogService.getWellnessLogById(id));
    }

    @GetMapping
    public ResponseEntity<List<WellnessLogResponseDTO>>
            getAllWellnessLogs() {

        return ResponseEntity.ok(
                wellnessLogService.getAllWellnessLogs());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WellnessLogResponseDTO>>
            getWellnessLogsByUserId(
                    @PathVariable Long userId) {

        return ResponseEntity.ok(
                wellnessLogService.getWellnessLogsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WellnessLogResponseDTO>
            updateWellnessLog(
                    @PathVariable Long id,
                    @Valid @RequestBody WellnessLogRequestDTO requestDTO) {

        return ResponseEntity.ok(
                wellnessLogService.updateWellnessLog(
                        id,
                        requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWellnessLog(
            @PathVariable Long id) {

        wellnessLogService.deleteWellnessLog(id);

        return ResponseEntity.ok(
                "Wellness log deleted successfully");
    }
}