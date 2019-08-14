package com.cts.crud.Service;

import java.util.List;

import com.cts.crud.Model.Customer;

public interface CustomerService {
	
	Customer save(Customer cus);
	Customer findById(Long cusId);
	List<Customer> findAll();
	void deletecus(Long id);
}
