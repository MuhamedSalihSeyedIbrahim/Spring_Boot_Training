package com.cts.crud.model;

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
	private Long empId;

	@NotEmpty(message = "firstname can not be empty")
	@NotNull(message = "first name can not be omitted")
	private String firstname;

	@NotEmpty(message = "lastname can not be empty")
	@NotNull(message = "first name can not be omitted")
	private String lastname;

	@Min(value = 25000, message = "basic can not be less than 25 thousand")
	@Max(value = 450000, message = "basic can not be greater than 4.5 lakhs")
	private double basic;

	@Enumerated(EnumType.STRING)
	private Department dept;
	
	@Pattern(regexp = "[1-9][0-9]{9}" ,message = "Invalid Mobile number")
	@NotNull(message = "Mobile number can not be omitted")
	private String mobileno;
	
	@Email
	@NotNull(message = "Email ID can not be omitted")
	private String emailid;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate joinDate;
	
	public Employee() {
		
	}

	public Employee(
			@NotEmpty(message = "firstname can not be empty") @NotNull(message = "first name can not be omitted") String firstname,
			@NotEmpty(message = "lastname can not be empty") @NotNull(message = "first name can not be omitted") String lastname,
			@Min(value = 25000, message = "basic can not be less than 25 thousand") @Max(value = 450000, message = "basic can not be greater than 4.5 lakhs") double basic,
			Department dept,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid Mobile number") @NotNull(message = "Mobile number can not be omitted") String mobileno,
			@Email @NotNull(message = "Email ID can not be omitted") String emailid, LocalDate joinDate) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.basic = basic;
		this.dept = dept;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.joinDate = joinDate;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
