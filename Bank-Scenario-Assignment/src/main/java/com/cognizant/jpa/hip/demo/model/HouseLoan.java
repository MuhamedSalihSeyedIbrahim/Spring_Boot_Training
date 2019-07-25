package com.cognizant.jpa.hip.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HouseLoan")
public class HouseLoan extends Loan {
	
	
	@Column(name="area")
	private String area;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="builderName")
	private String builderName;

	
	public HouseLoan(String lId, Bank bank, LocalDate applyDate, LocalDate sanctionDate, Double loanamount, Double emi,
			 String area, String locality, String builderName) {
		super(lId, bank, applyDate, sanctionDate, loanamount, emi);

		this.area = area;
		this.locality = locality;
		this.builderName = builderName;
	}

	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}
	
}
