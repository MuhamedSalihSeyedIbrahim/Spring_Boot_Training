package com.cognizant.jpa.hip.demo.model.onetonone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class BankAccount {
	
	@Id
	private String accno;
	
	@OneToOne
	@JoinColumn(name="aadhar")
	private customer customer;
	
	public BankAccount() {
		super();
	}

	public BankAccount(String accno, customer customer) {
		super();
		this.accno = accno;
		this.customer = customer;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public customer getCustomer() {
		return customer;
	}

	public void setCustomer(customer customer) {
		this.customer = customer;
	}

}
