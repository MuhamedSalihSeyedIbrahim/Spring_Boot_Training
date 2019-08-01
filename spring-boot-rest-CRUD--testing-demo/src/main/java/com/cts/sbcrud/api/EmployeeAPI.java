package com.cts.sbcrud.api;

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

import com.cts.sbcrud.service.EmployeeService;
import com.cts.sbcrud.model.*;

@RestController
@RequestMapping("/emps")
public class EmployeeAPI {
	@Autowired
	public EmployeeService empService;
	
	@GetMapping
	public ResponseEntity <List<Employee>> findAll(){
		return new ResponseEntity<List<Employee>>(empService.findAll(),HttpStatus.OK);
	}
	
	// Normal 
	// @GetMapping("/{empId}")
	
	//Regex Valudation 
	@GetMapping("/{empId:[0-9]{1,4}}")
	public ResponseEntity<Employee> findById(@PathVariable("empId") Long empId){
		ResponseEntity<Employee> response= null;
		System.out.print(empId);
		Employee emp =empService.findById(empId);
		
		if(emp==null) {
			response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			response = new ResponseEntity<>(emp,HttpStatus.OK);
		}
			
		return response;
	}
	
	
	//Regex Valudation  [firstdegit] [secong digit]{no of second digit}
	@GetMapping("/{mno:[1-9][0-9]{9}}")
	public ResponseEntity<Employee> findBymobileNumber(@PathVariable("mno") String mno){
		ResponseEntity<Employee> response= null;
		
		Employee emp =empService.findBymobileNumber(mno);
		
		if(emp==null) {
			response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			response = new ResponseEntity<>(emp,HttpStatus.OK);
		}
			
		return response;
	}
	
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> response = null;
		Employee empTemp = empService.findById(emp.getEmpId());
		if (empTemp == null) {
			emp = empService.save(emp);
			response = new ResponseEntity<>(emp, HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(emp, HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@PutMapping("/{empid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empid") Long empId, @RequestBody Employee emp) {
		ResponseEntity<Employee> response = null;
		Employee empTemp = empService.findById(empId);
		if (empTemp == null) {
			response = new ResponseEntity<>(emp, HttpStatus.NOT_ACCEPTABLE);
		} else {
			emp.setEmpId(empId);
			emp = empService.save(emp);
			response = new ResponseEntity<>(emp, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping("/{empid}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empId) {
		ResponseEntity<Void> response = null;
		Employee empTemp = empService.findById(empId);
		if (empTemp == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			empService.deleteById(empId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	
}

//Response
//{
//	   "empId":1,
//	    "firstName": "Muhamed",
//	    "lastName": "Salih",
//	    "basic": 50001.0,
//	    "dept": "DEVELOPMENT",
//	    "mobileNumber": "1231231231",
//	    "emailid": "muhamedsalih21@gmail.com",
//	    "joinDate": "2019-05-21"
//	}
