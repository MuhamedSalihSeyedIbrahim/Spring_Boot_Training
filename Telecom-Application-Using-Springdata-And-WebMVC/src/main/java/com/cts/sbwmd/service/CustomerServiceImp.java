package com.cts.sbwmd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbwmd.dao.CustomerRepository;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.model.customer;

@Service
public class CustomerServiceImp implements CustomerService {
  
	@Autowired
	private CustomerRepository cr;
	
	@Override
	public customer save(customer cus) {
		// TODO Auto-generated method stub
		return cr.save(cus);
	}

	@Override
	public void deleteById(Long cusId) {
		// TODO Auto-generated method stub
		cr.deleteById(cusId);
	}

	@Override
	public customer findBycusId(Long cusId) {
		// TODO Auto-generated method stub
		return cr.findBycusId(cusId);
	}

	@Override
	public customer findByemailId(String emailId) {
		// TODO Auto-generated method stub
		return cr.findByemailId(emailId);
	}

	@Override
	public customer findBymobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return cr.findBymobileNumber(mobileNumber);
	}


	@Override
	public customer findByaadhar(String aadhar) {
		// TODO Auto-generated method stub
		return cr.findByaadhar(aadhar);
	}

	
	@Override
	public List<customer> findAllBysimScheme(Scheme simScheme) {
		// TODO Auto-generated method stub
		return cr.findAllBysimScheme(simScheme);
	}

	
}
