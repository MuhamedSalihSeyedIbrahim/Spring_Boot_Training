package com.cts.sbwmd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cts.sbwmd.dao.PackageOffersRepository;
import com.cts.sbwmd.model.PackageDetail;
import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;
import java.util.*;

@Service
public class PackageServiceImp implements PackageService {

	@Autowired
	private PackageOffersRepository por;
	
	@Override
	public PackageOffers save(PackageOffers pkg) {
		return por.save(pkg);
	}

	@Override
	public void deleteById(Long Id) {
		por.deleteById(Id);
	}


	@Override
	public PackageOffers findByofferName(String offerName) {
		return por.findByofferName(offerName);
	}

	@Override
	public List<PackageOffers> findAllByValidityPeriodRange(int lb, int ub) {
		return por.findAllByValidityPeriodRange(lb, ub);
	}

	@Override
	public List<PackageOffers> findAllByCostRange(Double lb, Double ub) {
		return por.findAllByCostRange(lb, ub);
	}


	@Override
	public List<PackageOffers> findAll() {
		return por.findAll();
	}

	@Override
	public List<PackageOffers> findAllBysimScheme(Scheme simScheme) {
		// TODO Auto-generated method stub
		return por.findAllBysimScheme(simScheme);
	}

	@Override
	public PackageOffers findById(Long Id) {
		return por.findById(Id).orElse(null);
	}
	

}
