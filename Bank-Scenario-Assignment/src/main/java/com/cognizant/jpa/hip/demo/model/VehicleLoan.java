package com.cognizant.jpa.hip.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VehicleLoan")
public class VehicleLoan extends Loan {
	

	
	@Column(name="model")
	private String model;
	
	@Column(name="make")
	private String make;

	




	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public VehicleLoan(String lId, Bank bank, LocalDate applyDate, LocalDate sanctionDate, Double loanamount,
			Double emi,  String model, String make) {
		super(lId, bank, applyDate, sanctionDate, loanamount, emi);
	
		this.model = model;
		this.make = make;
	}
	
}
