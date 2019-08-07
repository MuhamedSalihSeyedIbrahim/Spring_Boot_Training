package com.cts.crud.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crud.Dao.PostPaid;
import com.cts.crud.Model.Postpaid;


@Service
public class PostpaidServiceImp implements PostpaidService
{
	@Autowired
	private PostPaid dao;
	
	@Override
	public Postpaid save(Postpaid data) {
		return dao.save(data);
	}

	@Override
	public List<Postpaid> findAll() {
		return dao.findAll();
	}

	@Override
	public Postpaid findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
	
}