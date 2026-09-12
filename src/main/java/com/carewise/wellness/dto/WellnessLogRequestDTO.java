package com.carewise.wellness.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class WellnessLogRequestDTO {

    @NotNull
    @Min(0)
    private Integer steps;

    @NotNull
    @DecimalMin("0.0")
    private Double waterIntake;

    @NotNull
    @DecimalMin("0.0")
    private Double sleepHours;

    @NotNull
    @Min(0)
    private Integer exerciseMinutes;

    @NotNull
    private LocalDate logDate;

    @NotNull
    private Long userId;

    public WellnessLogRequestDTO() {

    }

    public WellnessLogRequestDTO(Integer steps,
                                 Double waterIntake,
                                 Double sleepHours,
                                 Integer exerciseMinutes,
                                 LocalDate logDate,
                                 Long userId) {
        this.steps = steps;
        this.waterIntake = waterIntake;
        this.sleepHours = sleepHours;
        this.exerciseMinutes = exerciseMinutes;
        this.logDate = logDate;
        this.userId = userId;
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
        return "WellnessLogRequestDTO [steps=" + steps
                + ", waterIntake=" + waterIntake
                + ", sleepHours=" + sleepHours
                + ", exerciseMinutes=" + exerciseMinutes
                + ", logDate=" + logDate
                + ", userId=" + userId + "]";
    }
}