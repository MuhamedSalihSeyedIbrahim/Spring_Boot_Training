package com.cts.sbwmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbwmd.dao.PackageOffersRepository;
import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;

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
	public PackageOffers findById(Long id) {
		return por.findById(id).orElse(null);
	}

	@Override
	public PackageOffers findByofferName(String offerName) {
		return por.findByofferName(offerName);
	}

	@Override
	public PackageOffers findAllByValidityPeriodRange(int lb, int ub) {
		return por.findAllByValidityPeriodRange(lb, ub);
	}

	@Override
	public PackageOffers findAllByCostRange(Double lb, Double ub) {
		return por.findAllByCostRange(lb, ub);
	}

	@Override
	public List<PackageOffers> findAllBysimScheme(Scheme simScheme) {
		return por.findAllBysimScheme(simScheme);
	}
	

}
