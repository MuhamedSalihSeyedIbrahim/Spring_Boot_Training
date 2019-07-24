package com.cognizant.jpa.hip.demo.model.isa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Table(name="AllInOneTable")
//@DiscriminatorColumn(name="emp_type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("emp")

//@Inheritance(strategy=InheritanceType.JOINED)
//@Table(name="BaseEmps")


//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Table(name="onlyEmps")

public class Emp {
	
	@Id
	@Column(name="eid")
	private int empNo;
	
	@Column(name="ename")
	private String eName;
	
	@Column(name="sal")
	private double sal;

	public Emp() {
		super();
	}

	public Emp(int empNo, String eName, double sal) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.sal = sal;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
}
