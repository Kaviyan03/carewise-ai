package com.carewise.wellness.dto;

import java.time.LocalDate;

public class WellnessLogResponseDTO {

    private Long id;

    private Integer steps;

    private Double waterIntake;

    private Double sleepHours;

    private Integer exerciseMinutes;

    private LocalDate logDate;

    private Long userId;

    public WellnessLogResponseDTO() {

    }

    public WellnessLogResponseDTO(Long id,
                                  Integer steps,
                                  Double waterIntake,
                                  Double sleepHours,
                                  Integer exerciseMinutes,
                                  LocalDate logDate,
                                  Long userId) {

        this.id = id;
        this.steps = steps;
        this.waterIntake = waterIntake;
        this.sleepHours = sleepHours;
        this.exerciseMinutes = exerciseMinutes;
        this.logDate = logDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Double getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(Double waterIntake) {
        this.waterIntake = waterIntake;
    }

    public Double getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(Double sleepHours) {
        this.sleepHours = sleepHours;
    }

    public Integer getExerciseMinutes() {
        return exerciseMinutes;
    }

    public void setExerciseMinutes(Integer exerciseMinutes) {
        this.exerciseMinutes = exerciseMinutes;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WellnessLogResponseDTO [id=" + id
                + ", steps=" + steps
                + ", waterIntake=" + waterIntake
                + ", sleepHours=" + sleepHours
                + ", exerciseMinutes=" + exerciseMinutes
                + ", logDate=" + logDate
                + ", userId=" + userId + "]";
    }
}