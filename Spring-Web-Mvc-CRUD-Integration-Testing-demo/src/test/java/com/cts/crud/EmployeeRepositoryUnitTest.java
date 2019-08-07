package com.cts.crud;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.crud.dao.EmployeeRepository;
import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest 
public class EmployeeRepositoryUnitTest {
	
	private Employee emps[];
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeRepositoryUnitTest() {
		emps =new Employee[] {
				new Employee("Ashwin", "Kumar", 56544.55, Department.DEVELOPEMENT, "9988776655", "rpaswin008@gmail.com", LocalDate.now())
		};
	}
	
	@Before
	public void beforEachTest()
	{
		for(Employee e : emps)
		{
			entityManager.persist(e);
		}
		entityManager.flush();
	}
	
	@After
	public void afterEachTest()
	{
		for(Employee e : emps)
		{
			entityManager.remove(e);
		}
		entityManager.flush();
	}
	
	@Test
	public void whenFindByMobilenumber_thenReturnEmployee()
	{
		Employee e = employeeRepository.findBymobileno(emps[0].getMobileno());
		assertThat(e).isEqualTo(emps[0]);
	}
	
	@Test
	public void whenNoFindByMobilenumber_thenReturnNull()
	{
		Employee e = employeeRepository.findBymobileno("5577889900");
		assertThat(e).isNull();
	}
	
	
}
