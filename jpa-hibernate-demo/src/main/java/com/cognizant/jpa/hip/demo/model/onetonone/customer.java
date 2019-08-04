package com.cognizant.jpa.hip.demo.model.onetonone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AnntcustomerInd")
public class customer {
	
	@Id
	@Column(name="aadhar")
	private String aadhar;
	private String name;
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
	private BankAccount account;
	
	
	public customer() {
		super();
	}

	public customer(String aadhar, String name, BankAccount account) {
		super();
		this.aadhar = aadhar;
		this.name = name;
		this.account = account;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	

}
