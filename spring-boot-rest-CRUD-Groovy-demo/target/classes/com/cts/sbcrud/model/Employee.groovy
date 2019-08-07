package com.cts.sbcrud.model;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long empId;

	@NotEmpty(message = "firstname can not be empty")
	@NotNull(message = "firstname can not be omitted")
	 String firstName;

	@NotEmpty(message = "lastname can not be empty")
	@NotNull(message = "lastname can not be omitted")
	 String lastName;

	@Min(value = 25000, message = "basic can not be less than 25 thousand")
	@Max(value = 450000, message = "basic can not be greater than 4.5 lakhs")
	 double basic;

	
	  @Enumerated(EnumType.STRING)
	  Department dept;
	
	@Pattern(regexp = "[1-9][0-9]{9}" ,message = "Invalid Mobile number")
	@NotNull(message = "Mobile number can not be omitted")
	 String mobileNumber;
	
	@Email
	@NotNull(message = "Email ID can not be omitted")
	 String emailid;

	
}
