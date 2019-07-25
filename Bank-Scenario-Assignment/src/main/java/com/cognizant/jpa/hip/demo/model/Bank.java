package com.cognizant.jpa.hip.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Bank")
public class Bank {
	
	@Id
	@Column(name="accountNumber")
	private int accountNumber;
	
	@Column(name="cusName")
	private String cusName;
	
	@Column(name="BankName")
	private String bankName;
	
	@Column(name="aadharNumber")
	private String aadharNumber;


	@Column(name="LoanID")
	@OneToMany(cascade=CascadeType.ALL,mappedBy="lId")
	private List <Loan> Loans;


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public List<Loan> getLoans() {
		return Loans;
	}


	public void setLoans(List<Loan> loans) {
		Loans = loans;
	}
	

	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public Bank(int accountNumber, String cusName, String aadharNumber, List<Loan> loans,String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.cusName = cusName;
		this.aadharNumber = aadharNumber;
		Loans = loans;
		this.bankName=bankName;
	}


	
	
}
