package com.cognizant.jpa.hip.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PersonalLoan")
public class PersonalLoan extends Loan {
	

	
	@Column(name="basicSalary")
	private Double basicSalary;


	public PersonalLoan(String lId, Bank bank, LocalDate applyDate, LocalDate sanctionDate, Double loanamount,
			Double emi, Double basicSalary) {
		super(lId, bank, applyDate, sanctionDate, loanamount, emi);
		
		this.basicSalary = basicSalary;
	}


	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
}
