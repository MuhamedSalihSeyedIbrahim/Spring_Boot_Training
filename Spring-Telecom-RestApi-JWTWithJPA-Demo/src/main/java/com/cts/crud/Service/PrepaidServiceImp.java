package com.cts.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crud.Dao.PrePaidDao;
import com.cts.crud.Model.PrepaidOffers;


@Service
public class PrepaidServiceImp implements PrepaidService {
	
	@Autowired
	private PrePaidDao dao;


	@Override
	public List<PrepaidOffers> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public PrepaidOffers save(PrepaidOffers data) {
		// TODO Auto-generated method stub
		return dao.save(data);
	}

	@Override
	public PrepaidOffers findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
