package com.cts.crud.controller;

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

import com.cts.crud.Model.Customer;
import com.cts.crud.Service.CustomerService;



@RestController
@RequestMapping("/customer")
public class TelecomController {
	
	@Autowired
	private CustomerService cuservice;
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(name="id") Long id)
	{
		return new ResponseEntity<Customer>(cuservice.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getCustomers()
	{
		return new ResponseEntity<List<Customer>>(cuservice.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public  void deleteCus(@PathVariable Long id)
	{
		cuservice.deletecus(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateEmployee(@PathVariable Long id,@RequestBody Customer cus)
	{
		ResponseEntity<Customer> res= null;
		
		Customer cusdata = cuservice.findById(id);
		
		if(cusdata == null)
		{
			res  = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			cus.setId(id);
			res  = new ResponseEntity<>(cuservice.save(cus),HttpStatus.OK);
		}
		return res;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cus)
	{
		return new ResponseEntity<Customer>(cuservice.save(cus),HttpStatus.OK);
	}
	
}
