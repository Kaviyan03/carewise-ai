package com.carewise.health.dto;

public class HealthRecordResponseDTO {

    private Long id;

    private Double height;

    private Double weight;

    private String bloodGroup;

    private String allergies;

    private String medicalConditions;

    private Long userId;

    public HealthRecordResponseDTO() {

    }

    public HealthRecordResponseDTO(Long id, Double height,
            Double weight, String bloodGroup,
            String allergies, String medicalConditions,
            Long userId) {

        this.id = id;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.medicalConditions = medicalConditions;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "HealthRecordResponseDTO [id=" + id
                + ", height=" + height
                + ", weight=" + weight
                + ", bloodGroup=" + bloodGroup
                + ", allergies=" + allergies
                + ", medicalConditions=" + medicalConditions
                + ", userId=" + userId + "]";
    }
}