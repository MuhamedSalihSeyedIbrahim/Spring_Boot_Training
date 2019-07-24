package com.cognizant.jpa.hip.demo.model.isa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("manager")
@Table(name="onlyManager")
public class Manager extends Emp{
	
	@Column(name="hra")
	private double hra;
	

	public Manager() {
		super();
	}

	public Manager(int empNo, String eName, double sal, double hra) {
		super(empNo, eName, sal);
		this.hra = hra;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}
	
	

}
