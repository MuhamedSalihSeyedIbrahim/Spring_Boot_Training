package com.cts.crud;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.crud.dao.EmployeeRepository;
import com.cts.crud.model.Department;
import com.cts.crud.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = SpringWebMvcCrud1Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class EmployeeApiIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private EmployeeRepository repo;
	
	@org.junit.Before
	public void setUp()
	{

		Employee emp  = new  Employee("Ashwin", "Kumar", 56544.55, Department.DEVELOPEMENT, "9988776655", "rpaswin008@gmail.com", LocalDate.now());
		
		repo.save(emp);
	}
	
	@After
	public void tearDown()
	{
		repo.deleteAll();
	}
	
	@Test
	public void whenFindALL_thenReturnJsonArray() throws Exception
	{
		
		mvc.perform(get("/emps/get").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].mobileno", is("9988776655")));
	}

}
