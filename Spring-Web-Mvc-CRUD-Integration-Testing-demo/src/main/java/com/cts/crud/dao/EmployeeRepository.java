package com.cts.crud.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findBymobileno(String mobileno);
	Employee findByemailid(String emailid);
	List<Employee> findAllBydept(Department dept);
	List<Employee> findAllByjoinDate(LocalDate joinDate);
	
	@Query("Select e from Employee e where e.basic>=:lb and e.basic<:hb")
	List<Employee> findAllByBasicRange(double lb,double hb);
}
