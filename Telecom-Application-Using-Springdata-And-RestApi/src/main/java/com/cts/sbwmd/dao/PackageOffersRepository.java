package com.cts.sbwmd.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;

@Repository
public interface PackageOffersRepository extends JpaRepository<PackageOffers, Long> {

	PackageOffers findByofferName(String offerName);
	Optional<PackageOffers> findById(Long id);
	
	List<PackageOffers> findAll();
	List<PackageOffers> findAllBysimScheme(Scheme simScheme);
	
	@Query("SELECT e FROM PackageOffers e Where e.ValidityPeriod>=:lb and e.ValidityPeriod<:ub ")
	public List<PackageOffers> findAllByValidityPeriodRange(int lb,int ub);
	
	@Query("SELECT e FROM PackageOffers e Where e.Cost>=:lb and e.Cost<:ub ")
	public List<PackageOffers> findAllByCostRange(Double lb,Double ub);
	
	
	
}
