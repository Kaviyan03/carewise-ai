package com.carewise.health.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HealthRecordRequestDTO {

    @NotNull
    @DecimalMin("1.0")
    private Double height;

    @NotNull
    @DecimalMin("1.0")
    private Double weight;

    @NotBlank
    private String bloodGroup;

    private String allergies;

    private String medicalConditions;

    @NotNull
    private Long userId;

    public HealthRecordRequestDTO() {

    }

    public HealthRecordRequestDTO(Double height, Double weight,
            String bloodGroup, String allergies,
            String medicalConditions, Long userId) {

        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.medicalConditions = medicalConditions;
        this.userId = userId;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HealthRecordRequestDTO [height=" + height
                + ", weight=" + weight
                + ", bloodGroup=" + bloodGroup
                + ", allergies=" + allergies
                + ", medicalConditions=" + medicalConditions
                + ", userId=" + userId + "]";
    }
}