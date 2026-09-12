package com.carewise.user.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 50)
	@Column(nullable = false)
	private String firstName;
	
	@NotBlank
	@Size(min = 2, max = 50)
	@Column(nullable = false)
	private String lastName;
	
	@NotBlank
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 20)
	private String password;
	
	@NotNull
	@Min(1)
	@Max(120)
	private Integer age;
	
	@NotBlank
	@Column(nullable = false)
	private String gender;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public User() {
		
	}

	public User(Long id, String firstName,
			String lastName, String email,
			String password, Integer age,
			 String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
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
	
	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age="
				+ age + ", gender=" + gender + ", createdAt=" + createdAt + "]";
	}
	
	

}
