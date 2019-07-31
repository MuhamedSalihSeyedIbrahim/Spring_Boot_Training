package com.cts.sbcrud.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbcrud.dao.EmployeeRepository;
import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;
@Service
public class EmployeeServiceImp implements EmployeeService {
		@Autowired
		private EmployeeRepository empRepo;
	
	
	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public void deleteById(Long empId) {
		empRepo.deleteById(empId);
	}


	@Override
	public Employee findIdByemailid(String email) {
		return empRepo.findByemailid(email);
	}

	public Employee findById(Long empId) {
		return empRepo.findById(empId).orElse(null);
	}
	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public List<Employee> findAllByDept(Department dept) {
		return empRepo.findAllByDept(dept);
	}

	@Override
	public List<Employee> findAllByjoinDate(LocalDate joinDate) {
		return empRepo.findAllByjoinDate(joinDate);
	}

	@Override
	public List<Employee> findAllByBasicRange(double lb, double ub) {
		 return empRepo.findAllByBasicRange(lb, ub);
	}


	@Override
	public Employee findBymobileNumber(String mobileNumber) {
		return empRepo.findBymobileNumber(mobileNumber);
	}
}
