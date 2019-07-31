package com.cts.sbcrud.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;


public interface EmployeeService {
	Employee save(Employee emp);
	void deleteById(Long empId);
	
	Employee findIdByemailid(String email);
	Employee findBymobileNumber(String mobileNumber);
	
	List<Employee> findAll();
	List<Employee> findAllByDept(Department dept);
	List<Employee> findAllByjoinDate(LocalDate joinDate);
	List<Employee> findAllByBasicRange(double lb, double ub);
	Employee findById(Long empId);

	
}
