package com.cognizant.jpa.hip.demo.model.isa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("contract")
@Table(name="onlyContractEmp")
public class ContractEmp extends Emp{
	
	@Column(name="cdur")
	private int contractDur;
	
	
	public ContractEmp() {
		super();
	}

	public ContractEmp(int empNo, String eName, double sal, int contractDur) {
		super(empNo, eName, sal);
		this.contractDur = contractDur;
	}

	public int getContractDur() {
		return contractDur;
	}

	public void setContractDur(int contractDur) {
		this.contractDur = contractDur;
	}
	

}
