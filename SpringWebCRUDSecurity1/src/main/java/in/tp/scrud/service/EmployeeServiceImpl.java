package in.tp.scrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.tp.scrud.dao.IEmployeeRepository;
import in.tp.scrud.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeRepository empRepo;

	@Transactional
	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
		
	@Transactional
	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	@Transactional
	@Override
	public void deleteEmployee(Long empId) {
		empRepo.deleteById(empId);
	}

	@Override
	public List<Employee> listEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Optional<Employee> optEmp = empRepo.findById(empId);
		Employee emp = optEmp.isPresent()?optEmp.get():null;
		return emp;
	}
	
}
