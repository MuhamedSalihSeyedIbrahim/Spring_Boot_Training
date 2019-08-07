package com.cts.crud.Service;

import java.util.List;

import com.cts.crud.Model.PrepaidOffers;


public interface PrepaidService  {
	
	PrepaidOffers save(PrepaidOffers data);
	List<PrepaidOffers> findAll();
	PrepaidOffers findById(Long id);
}
