package com.cts.crud.Service;

import java.util.List;

import com.cts.crud.Model.Postpaid;


public interface PostpaidService {
	
	Postpaid save(Postpaid data);
	List<Postpaid> findAll();
	Postpaid findById(Long id);
}
