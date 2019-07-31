package com.cts.sbcrud.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;

//Repository annotation used to for querying which has an interface with nomenclature method where it is automatically implemented by spring boot it self to query the data from database
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 
	// return findBy<bean |table Model Class field name>(param) --> findBy (find single Row) 
	Employee findBymobileNumber(String mobileNumber);
	Employee findByemailid(String email);

	// return Collection findAll<bean |table Model Class field name>(param) --> findAll (find single Row) 
	List<Employee> findAllByDept(Department dept);
	List<Employee> findAllByJoinDate(LocalDate joinDate);
	
	//custom Query using JPQL which use ":<param passed>" to where clause 
	@Query("SELECT e FROM Employee e Where e.basic>=:lb and e.basic<:ub ")
	List<Employee> findAllByBasicRange(double lb , double ub);
	List<Employee> findAllByjoinDate(LocalDate joinDate);
	
}

