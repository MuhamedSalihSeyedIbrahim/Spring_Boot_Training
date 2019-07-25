package com.cognizant.jpa.hip.demo.model;

import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("unused")

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Loan")
public class Loan {


	@Id
	@Column(name="lId")
	private String lId;
	
	@ManyToOne
	@JoinColumn(name="accountNumber")
	private Bank bank;
	
	@Column(name="applyDate")
	private LocalDate applyDate ;
	
	@Column(name="sanctionDate")
	private LocalDate sanctionDate;
	
	@Column(name="Loanamount")
	private Double Loanamount;
	
	@Column(name="emi")
	private Double emi;

	public String getlId() {
		return lId;
	}

	public void setlId(String lId) {
		this.lId = lId;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}

	public LocalDate getSanctionDate() {
		return sanctionDate;
	}

	public void setSanctionDate(LocalDate sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public Double getLoanamount() {
		return Loanamount;
	}

	public void setLoanamount(Double loanamount) {
		Loanamount = loanamount;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public Loan(String lId, Bank bank, LocalDate applyDate, LocalDate sanctionDate, Double loanamount, Double emi) {
		
		this.lId = lId;
		this.bank = bank;
		this.applyDate = applyDate;
		this.sanctionDate = sanctionDate;
		Loanamount = loanamount;
		this.emi = emi;
	}

	

}
