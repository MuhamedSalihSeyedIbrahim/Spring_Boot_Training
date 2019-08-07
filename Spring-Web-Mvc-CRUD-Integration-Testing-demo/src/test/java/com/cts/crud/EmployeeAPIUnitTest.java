package com.cts.crud;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.crud.Controller.EmployeeApI;
import com.cts.crud.EmployeeService.EmployeeService;
import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeApI.class)
public class EmployeeAPIUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private EmployeeService service;
	
	@Test
	public void whenFindAll_thenReturnJsonArray() throws Exception{
		Employee emp  = new  Employee("Ashwin", "Kumar", 56544.55, Department.DEVELOPEMENT, "9988776655", "rpaswin008@gmail.com", LocalDate.now());
		
		List<Employee> allemp=Arrays.asList(emp);
		
		given(service.findAll()).willReturn(allemp);
		
		mvc.perform(get("/emps/get").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].mobileno", is(emp.getMobileno())));
	}
}
