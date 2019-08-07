package com.cts.crud.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.crud.Model.Customer;



@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	
}
