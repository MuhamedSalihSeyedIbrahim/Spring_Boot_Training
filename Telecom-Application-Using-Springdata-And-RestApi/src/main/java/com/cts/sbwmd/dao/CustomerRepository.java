package com.cts.sbwmd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sbwmd.model.PackageDetail;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.model.customer;

@Repository

public interface CustomerRepository extends JpaRepository<customer, Long> {
	
	customer findBycusId(Long cusId);
	customer findByemailId(String emailId);
	customer findBymobileNumber(String mobileNumber);
	customer findBysimScheme(Scheme simScheme);
	customer findByaadhar(String aadhar);
	customer findBypackageDetailChoosed(PackageDetail packageDetailChoosed);
	
	
	List<customer> findAllBysimScheme(Scheme simScheme);
	List<customer> findAllBypackageDetailChoosed(PackageDetail packageDetailChoosed);
	List<customer> findAll();
	

}
