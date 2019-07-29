package com.cts.sbwmd.model;

public class KYC {
private String fullName, address, email,packageDetails;
private Integer phoneNo, aadhar, customerId;

public KYC() {}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public Integer getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(Integer phoneNo) {
	this.phoneNo = phoneNo;
}
public Integer getAadhar() {
	return aadhar;
}
public void setAadhar(Integer aadhar) {
	this.aadhar = aadhar;
}

public void customerIdGenrator() {
	if(this.phoneNo!=null && this.address!=null)
		this.customerId=this.phoneNo+this.aadhar;
	else
		this.customerId=0;
	}

public Integer getCustomerId() {
	return customerId;
}
public KYC(String fullName, String address, String email, Integer phoneNo, Integer aadhar) {
	super();
	this.fullName = fullName;
	this.address = address;
	this.email = email;
	this.phoneNo = phoneNo;
	this.aadhar = aadhar;
	this.customerIdGenrator();

}
public String getPackageDetails() {
	return packageDetails;
}
public void setPackageDetails(String packageDetails) {
	this.packageDetails = packageDetails;
}



}
