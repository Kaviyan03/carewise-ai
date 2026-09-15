package com.carewise.user.dto;

import java.time.LocalDateTime;

public class UserResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
    
    private String role;

    private Integer age;

    private String gender;

    private LocalDateTime createdAt;

    public UserResponseDTO() {

    }

    public UserResponseDTO(Long id, String firstName, String lastName,
                           String email,String role, Integer age,
                           String gender, LocalDateTime createdAt) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
    		return role;
    }
    
    public void setRole(String role) {
    		this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserResponseDTO [id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", role=" + role+
                ", age=" + age +
                ", gender=" + gender +
                ", createdAt=" + createdAt + "]";
    }
}