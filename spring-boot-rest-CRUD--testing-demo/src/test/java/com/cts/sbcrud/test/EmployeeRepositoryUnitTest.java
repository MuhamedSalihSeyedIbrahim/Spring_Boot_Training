package com.cts.sbcrud.test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.sbcrud.dao.EmployeeRepository;
import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;

@RunWith(SpringRunner.class) // a bridge between spring boot test feature and JUnit
@DataJpaTest //configure H2 , an inMemory database , setting Hibernate , Spring Date and
//DataSource , performing an @EntityScan turning on SQL Logging

public class EmployeeRepositoryUnitTest {

	private Employee[] emps;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeRepositoryUnitTest() {
		emps= new Employee[] {
			new Employee( "firstName", "lastName", 50000.02, Department.SALES, "7408529630", "emailid@xzc", LocalDate.now())	
		};
	}
	
	@org.junit.Before
	public void beforeEachTest() {
		for(Employee e: emps) {
			entityManager.persist(e);
		}
		entityManager.flush();
	}
	
	@After
	public void afterEachTest() {
		for(Employee e: emps) {
			entityManager.remove(e);
		}
		entityManager.flush();
	}
	
	@Test
	public void whenfindByMobileNumber_thenReturnEmployee() {
		Employee e=employeeRepository.findBymobileNumber(emps[0].getMobileNumber());
		assertThat(e).isEqualTo(emps[0]);
	}
	
	
	@Test
	public void whenfindByMobileNumber_withNonExistingMobileNumber_thenReturnEmployee() {
		Employee e=employeeRepository.findBymobileNumber("1235203465");
		assertThat(e).isNull();
		
	}
	
	
}
