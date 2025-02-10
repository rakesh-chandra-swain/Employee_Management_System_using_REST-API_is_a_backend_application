package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees_DATABASE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @NotBlank(message = "Name must not be blank")
	@Column(name="first_name",nullable = true)
	 @Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String firstName;
	@Column(name="last_name",nullable = true)
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String lastName;
	@Email(message = "Please provide a valid email")
	@Column(name="email_id", nullable = false, unique = true,length = 50)
	private String email;
}
