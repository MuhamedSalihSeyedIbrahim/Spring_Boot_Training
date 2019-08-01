package com.cts.sbwmd.service;


import java.util.List;

import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;

public interface PackageService {
	
	PackageOffers save(PackageOffers pkg);
	void deleteById(Long Id);
	
	PackageOffers findById(Long id);
	PackageOffers findByofferName(String offerName);
	PackageOffers findAllByValidityPeriodRange(int lb,int ub);
	PackageOffers findAllByCostRange(Double lb,Double ub);
	List<PackageOffers> findAllBysimScheme (Scheme PackageOffers);
}
