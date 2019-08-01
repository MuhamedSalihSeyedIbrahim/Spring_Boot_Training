
package com.cts.sbwmd.service;

import java.util.List;
import com.cts.sbwmd.model.PackageDetail;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.model.customer;

public interface CustomerService {
	
	customer save(customer cus);
	void deleteById(Long cusId);
	
	customer findBycusId(Long cusId);
	customer findByemailId(String emailId);
	customer findBymobileNumber(String mobileNumber);
	customer findByaadhar(String aadhar);
	
	
	List<customer> findAllBysimScheme(Scheme simScheme);
}
