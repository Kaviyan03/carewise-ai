package com.carewise.wellness.entity;

import java.time.LocalDate;

import com.carewise.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "wellness")
public class WellnessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public WellnessLog() {
    	
    }

	public WellnessLog(Long id, Integer steps, Double waterIntake,
			Double sleepHours, Integer exerciseMinutes, LocalDate logDate,
			User user) {
		super();
		this.id = id;
		this.steps = steps;
		this.waterIntake = waterIntake;
		this.sleepHours = sleepHours;
		this.exerciseMinutes = exerciseMinutes;
		this.logDate = logDate;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
	    return "WellnessLog [id=" + id
	            + ", steps=" + steps
	            + ", waterIntake=" + waterIntake
	            + ", sleepHours=" + sleepHours
	            + ", exerciseMinutes=" + exerciseMinutes
	            + ", logDate=" + logDate + "]";
	}

    
    

}