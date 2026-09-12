package com.carewise.health.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carewise.health.dto.HealthRecordRequestDTO;
import com.carewise.health.dto.HealthRecordResponseDTO;
import com.carewise.health.service.HealthRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/health-records")
public class HealthRecordController {

    private final HealthRecordService healthRecordService;

    public HealthRecordController(
            HealthRecordService healthRecordService) {

        this.healthRecordService = healthRecordService;
    }

    @PostMapping
    public ResponseEntity<HealthRecordResponseDTO> createHealthRecord(
            @Valid @RequestBody HealthRecordRequestDTO requestDTO) {

        HealthRecordResponseDTO responseDTO =
                healthRecordService.createHealthRecord(requestDTO);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthRecordResponseDTO>
            getHealthRecordById(@PathVariable Long id) {

        return ResponseEntity.ok(
                healthRecordService.getHealthRecordById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<HealthRecordResponseDTO>
            getHealthRecordByUserId(
                    @PathVariable Long userId) {

        return ResponseEntity.ok(
                healthRecordService.getHealthRecordByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<HealthRecordResponseDTO>>
            getAllHealthRecords() {

        return ResponseEntity.ok(
                healthRecordService.getAllHealthRecords());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthRecordResponseDTO>
            updateHealthRecord(
                    @PathVariable Long id,
                    @Valid @RequestBody HealthRecordRequestDTO requestDTO) {

        return ResponseEntity.ok(
                healthRecordService.updateHealthRecord(
                        id,
                        requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHealthRecord(
            @PathVariable Long id) {

        healthRecordService.deleteHealthRecord(id);

        return ResponseEntity.ok(
                "Health record deleted successfully");
    }
}