package com.cts.sbcrud.test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.sbcrud.dao.EmployeeRepository;
import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;
import com.cts.sbcrud.service.EmployeeService;
import com.cts.sbcrud.service.EmployeeServiceImp;
@RunWith(SpringRunner.class)
public class EmployeeServiceImplUnitTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {
		
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImp();
		}
	}
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	@org.junit.Before
	public void setUp() {

		Employee emp=new Employee("gorle","sunny",40000,Department.DEVELOPMENT,"7739322210","gorleshanmukh@gmail.com",LocalDate.now());
		Mockito.when(employeeRepository.findBymobileNumber(emp.getMobileNumber())).thenReturn(emp);
//		Mockito.when(employeeRepository.findBymobileNumber(Mocikto.anyString()).thenReturn(null);

	}
	@Test
	public void whenValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno = "7739322210";
		Employee found = employeeService.findBymobileNumber(mno);
		assertThat(found.getMobileNumber()).isEqualTo(mno);
	}
}
