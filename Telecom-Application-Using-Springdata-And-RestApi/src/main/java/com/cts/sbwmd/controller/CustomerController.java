package com.cts.sbwmd.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbwmd.model.customer;
import com.cts.sbwmd.service.CustomerService;

@RestController

public class CustomerController {
	
	@Autowired
	private CustomerService cuservice;
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<customer> getCustomer(@PathVariable(name="id") Long id)
	{
		return new ResponseEntity<customer>(cuservice.findBycusId(id),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<customer>> getCustomers()
	{
		return new ResponseEntity<List<customer>>(cuservice.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public  void deleteCus(@PathVariable Long id)
	{
		cuservice.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<customer> updateEmployee(@PathVariable Long id,@RequestBody customer cus)
	{
		ResponseEntity<customer> res= null;
		
		customer cusdata = cuservice.findBycusId(id);
		
		if(cusdata == null)
		{
			res  = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			cus.setCusId(id);
			res  = new ResponseEntity<>(cuservice.save(cus),HttpStatus.OK);
		}
		return res;
	}
	
	@PostMapping("/create")
	public ResponseEntity<customer> createCustomer(@RequestBody customer cus)
	{
		return new ResponseEntity<customer>(cuservice.save(cus),HttpStatus.OK);
	}
	
	
}
