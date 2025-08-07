package com.example.userprofile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users2")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@NotNull(message = "name is required")
	@NotBlank(message = "name is required")
	//@NotEmpty(message = "name is required")
	//@Size(min = 3,max = 50,message = "name should is greater than 2")
	private String name;
	@NotNull(message = "email is required")
	@Email(message = "invalid email format")
	private String email;
	@NotNull(message = "phone number is required")
	//@Size(min = 10,max=10,message = "phone number should be 10 digits")
	@Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
	private String phone;
	
	public UserModel(int id,
			String name,
			String email,
			String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
