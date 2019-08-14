package com.cts.crud.EmployeeService;

import java.time.LocalDate;
import java.util.List;

import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee emp);
	Employee findById(Long empId);
	Employee findBymobileno(String mobileno);
	Employee findByemailid(String emailid);
	
	String deleteById(Long empId);
	
	List<Employee> findAll();
	List<Employee> findAllBydept(Department dept);
	List<Employee> findAllByjoinDate(LocalDate joinDate);
	List<Employee> findAllByBasicRange(double lb,double hb);

}
