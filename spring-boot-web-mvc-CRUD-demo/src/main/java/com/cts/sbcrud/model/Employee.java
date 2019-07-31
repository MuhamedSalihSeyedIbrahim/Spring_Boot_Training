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
	private Long empId;

	@NotEmpty(message = "firstname can not be empty")
	@NotNull(message = "firstname can not be omitted")
	private String firstName;

	@NotEmpty(message = "lastname can not be empty")
	@NotNull(message = "lastname can not be omitted")
	private String lastName;

	@Min(value = 25000, message = "basic can not be less than 25 thousand")
	@Max(value = 450000, message = "basic can not be greater than 4.5 lakhs")
	private double basic;

	
	  @Enumerated(EnumType.STRING)
	 private Department dept;
	
	@Pattern(regexp = "[1-9][0-9]{9}" ,message = "Invalid Mobile number")
	@NotNull(message = "Mobile number can not be omitted")
	private String mobileNumber;
	
	@Email
	@NotNull(message = "Email ID can not be omitted")
	private String emailid;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate joinDate;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
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
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
