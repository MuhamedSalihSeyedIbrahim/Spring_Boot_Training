package com.cts.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crud.EmployeeService.EmployeeService;
import com.cts.crud.model.Employee;

@RestController
@RequestMapping("/emps")
public class EmployeeApI {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> findAll()
	{
		return new ResponseEntity<List<Employee>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id:[0-9]{1,4}}")
	public ResponseEntity<Employee> findEmp(@PathVariable("id") Long id)
	{
		ResponseEntity<Employee> response = null;
		Employee emp = service.findById(id);
		
		if(emp == null)
		{
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			response = new ResponseEntity<>(emp,HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/get/{mob:[1-9][0-9]{9}}")
	public ResponseEntity<Employee> findByMob(@PathVariable("mob") String mob)
	{
		ResponseEntity<Employee> response = null;
		Employee emp = service.findBymobileno(mob);
		
		if(emp == null)
		{
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			response = new ResponseEntity<>(emp,HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/get/{lv}/{uv}")
	public  ResponseEntity<List<Employee>> findByMob(@PathVariable("lv") double lv,
			@PathVariable("uv") double uv)
	{
		return new ResponseEntity<>(service.findAllByBasicRange(lv, uv),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(service.save(emp),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee emp)
	{
		ResponseEntity<Employee> res= null;
		
		Employee empdata = service.findById(id);
		
		if(empdata == null)
		{
			res  = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			emp.setEmpId(id);
			res  = new ResponseEntity<>(service.save(emp),HttpStatus.OK);
		}
		
		return res;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  DeleteEmployee(@PathVariable("id") Long id)
	{
		return new ResponseEntity<String>(service.deleteById(id),HttpStatus.OK);
	}

}
