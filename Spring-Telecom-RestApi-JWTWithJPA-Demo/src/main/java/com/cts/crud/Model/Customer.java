package com.cts.crud.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Firstname should not be Empty")
	@NotNull(message = "Firstname can not be ommited")
	private String firstname;
	
	@NotEmpty(message = "Lastname should not be Empty")
	@NotNull(message = "Lastname can not be ommited")
	private String lastname;
	
	@NotEmpty(message = "Lastname should not be Empty")
	@NotNull(message = "Lastname can not be ommited")
	@Pattern(regexp = "[1-9][0-9]{9}" ,message = "Invalid Mobile number")
	private String mobileno;
	
	@NotEmpty(message = "EmailId should not be Empty")
	@NotNull(message = "EmailId can not be ommited")
	@Email
	@Column(unique = true)
	private String emailid;
	
	@NotEmpty(message = "AadharNo should not be Empty")
	@NotNull(message = "AadharNo can not be ommited")
	@Pattern(regexp = "[1-9][0-9]{11}" ,message = "Invalid Aadhar number")
	@Column(unique = true)
	private String aadharno;
	
	@NotNull(message = "DOB can not be omitted")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate DOB;
	
	@OneToOne
	@JoinColumn(name="offer_id")
	private OfferPackage offerdetails;
	
	public Customer()
	{
		
		
	}
	
	
	



	public Customer(Long id,
			@NotEmpty(message = "Firstname should not be Empty") @NotNull(message = "Firstname can not be ommited") String firstname,
			@NotEmpty(message = "Lastname should not be Empty") @NotNull(message = "Lastname can not be ommited") String lastname,
			@NotEmpty(message = "Lastname should not be Empty") @NotNull(message = "Lastname can not be ommited") @Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid Mobile number") String mobileno,
			@NotEmpty(message = "EmailId should not be Empty") @NotNull(message = "EmailId can not be ommited") @Email String emailid,
			@NotEmpty(message = "AadharNo should not be Empty") @NotNull(message = "AadharNo can not be ommited") String aadharno,
			@NotNull(message = "DOB can not be omitted") LocalDate dOB, OfferPackage offerdetails) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.aadharno = aadharno;
		DOB = dOB;
		this.offerdetails = offerdetails;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}


	public LocalDate getDOB() {
		return DOB;
	}


	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileno=" + mobileno
				+ ", emailid=" + emailid + ", aadharno=" + aadharno + ", DOB=" + DOB + "]";
	}
	
	public OfferPackage getOfferdetails() {
		return offerdetails;
	}



	public void setOfferdetails(OfferPackage offerdetails) {
		this.offerdetails = offerdetails;
	}

	
	
	
	
}
