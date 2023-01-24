package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	
	private String role;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	@Email(message =  "Invalid Email Addrress Please Try Again..!!")
	private String email;
	
	@Column(unique = true)
	private String phoneNumber;
	
	private Integer salary;
	
	
	private Integer  reportingManagerId;
	
}
