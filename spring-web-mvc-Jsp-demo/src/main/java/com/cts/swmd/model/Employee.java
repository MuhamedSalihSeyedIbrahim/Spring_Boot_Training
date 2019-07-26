package com.cts.swmd.model;

public class Employee {
	private int empId;
	private String name;
	private double basic;
	private double hra;
	private double ta;
	private String designation;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String name, double basic, double hra, double ta, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.basic = basic;
		this.hra = hra;
		this.ta = ta;
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getTa() {
		return ta;
	}
	public void setTa(double ta) {
		this.ta = ta;
	}


}