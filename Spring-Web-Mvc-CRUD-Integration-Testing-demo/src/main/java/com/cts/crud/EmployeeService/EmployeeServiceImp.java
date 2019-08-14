package com.cts.crud.EmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crud.dao.EmployeeRepository;
import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empdao;

	@Override
	public Employee save(Employee emp) {
	
		return empdao.save(emp);
	}

	@Override
	public Employee findById(Long empId) {
	  return empdao.findById(empId).orElse(null);
	}

	@Override
	public Employee findBymobileno(String mobileno) {
		// TODO Auto-generated method stub
		return empdao.findBymobileno(mobileno);
	}

	@Override
	public Employee findByemailid(String emailid) {
		// TODO Auto-generated method stub
		return empdao.findByemailid(emailid);
	}

	@Override
	public String deleteById(Long empId) {
		empdao.deleteById(empId);
		return "Delete Successfully";
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empdao.findAll();
	}

	@Override
	public List<Employee> findAllBydept(Department dept) {
		// TODO Auto-generated method stub
		return empdao.findAllBydept(dept);
	}

	@Override
	public List<Employee> findAllByjoinDate(LocalDate joinDate) {
		// TODO Auto-generated method stub
		return empdao.findAllByjoinDate(joinDate);
	}

	@Override
	public List<Employee> findAllByBasicRange(double lb, double hb) {
		// TODO Auto-generated method stub
		return empdao.findAllByBasicRange(lb, hb);
	}

}
