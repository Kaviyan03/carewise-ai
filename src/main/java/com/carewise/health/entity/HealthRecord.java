package com.carewise.health.entity;

import com.carewise.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "health_record")
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    
    @OneToOne
    @JoinColumn(
        name = "user_id",
        unique = true,
        nullable = false
    )
    private User user;
    
    public HealthRecord() {
    	
    }
    
    public HealthRecord(Long id, Double height, Double weight,
			 String bloodGroup, String allergies, String medicalConditions, User user) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.allergies = allergies;
		this.medicalConditions = medicalConditions;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "HealthRecord [id=" + id + ", height=" + height + ", weight=" + weight + ", bloodGroup=" + bloodGroup
				+ ", allergies=" + allergies + ", medicalConditions=" + medicalConditions + "]";
	}
	
	

}