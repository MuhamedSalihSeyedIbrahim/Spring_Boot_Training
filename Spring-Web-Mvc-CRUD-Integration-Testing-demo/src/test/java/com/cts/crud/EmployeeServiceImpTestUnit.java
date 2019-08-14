package com.cts.crud;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.crud.EmployeeService.EmployeeService;
import com.cts.crud.EmployeeService.EmployeeServiceImp;
import com.cts.crud.dao.EmployeeRepository;
import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@RunWith(SpringRunner.class)
public class EmployeeServiceImpTestUnit {
	
	@TestConfiguration
	static class EmployeeServiceImpTestContextConfig{
		
		@Bean
		public EmployeeService employeeService()
		{
			return new EmployeeServiceImp();
		}
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() {
		Employee emp = new Employee("Ashwin", "Kumar", 56544.55, Department.DEVELOPEMENT, "9988776655", "rpaswin008@gmail.com", LocalDate.now());
		Mockito.when(employeeRepository.findBymobileno(emp.getMobileno())).thenReturn(emp);
	
	}
	

	@Test
	public void whenFindByMobilenumber_thenReturnEmployee()
	{
		String mo="9988776655";
		Employee found = employeeService.findBymobileno(mo);
		assertThat(found.getMobileno()).isEqualTo(mo);
	}
	
	@Test
	public void whenNoFindByMobilenumber_thenReturnNull()
	{
		String mo="9980776655";
		Employee found = employeeService.findBymobileno(mo);
		assertThat(found).isNull();
	}
}
