package com.cts.sbwmd.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cts.sbwmd.model.*;

@Entity
@Table(name="customer")
public class customer {
	@ModelAttribute
	public void populateCommonData(Model model) {
		model.addAttribute("Scheme", Scheme.values());
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cusId;
	
	@NotEmpty(message = "firstname can not be empty")
	@NotNull(message = "firstname can not be omitted")
	private String firstName;
	
	@NotEmpty(message = "lastname can not be empty")
	@NotNull(message = "lastname can not be omitted")
	private String lastName;
	
	//@Email
	@NotNull(message = "Email ID can not be omitted")
	private String emailId;
	
	//@Pattern(regexp = "[1-9][0-9]{9}" ,message = "Invalid Mobile number")
	@NotNull(message = "Mobile number can not be omitted")
	private String mobileNumber;
	
	@Enumerated(EnumType.STRING)
	private Scheme simScheme;
	
	@NotEmpty(message = "aadhar can not be empty")
	@NotNull(message = "aadhar can not be omitted")
	private String aadhar;

	
	
	@OneToOne
	@JoinColumn(name="Id")
	private PackageDetail packageDetailChoosed;



	public Long getCusId() {
		return cusId;
	}



	public void setCusId(Long cusId) {
		this.cusId = cusId;
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



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public Scheme getSimScheme() {
		return simScheme;
	}



	public void setSimScheme(Scheme simScheme) {
		this.simScheme = simScheme;
	}



	public String getAadhar() {
		return aadhar;
	}



	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}



	public PackageDetail getPackageDetailChoosed() {
		return packageDetailChoosed;
	}



	public void setPackageDetailChoosed(PackageDetail packageDetailChoosed) {
		this.packageDetailChoosed = packageDetailChoosed;
	}



	public customer(Long cusId,
			@NotEmpty(message = "firstname can not be empty") @NotNull(message = "firstname can not be omitted") String firstName,
			@NotEmpty(message = "lastname can not be empty") @NotNull(message = "lastname can not be omitted") String lastName,
			@NotNull(message = "Email ID can not be omitted") String emailId,
			@NotNull(message = "Mobile number can not be omitted") String mobileNumber, Scheme simScheme,
			@NotEmpty(message = "aadhar can not be empty") @NotNull(message = "aadhar can not be omitted") String aadhar,
			PackageDetail packageDetailChoosed) {
		super();
		this.cusId = cusId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.simScheme = simScheme;
		this.aadhar = aadhar;
		this.packageDetailChoosed = packageDetailChoosed;
	}



	public customer() {
		super();
	}
	
	
	
}
