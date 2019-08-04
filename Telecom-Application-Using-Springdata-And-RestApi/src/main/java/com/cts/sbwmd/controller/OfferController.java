package com.cts.sbwmd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.service.PackageServiceImp;


@RestController
@RequestMapping("/Offers")
public class OfferController {
	
	@Autowired
	private PackageServiceImp ps;
	
	
	@GetMapping("/prepaid")
	public ResponseEntity<List<PackageOffers>> getPrepaidOffers()
	{
		return new ResponseEntity<List<PackageOffers>>(ps.findAllBysimScheme(Scheme.PREPAID),HttpStatus.OK);
	}
	
	@GetMapping("/postpaid")
	public ResponseEntity<List<PackageOffers>> getPostpaidOffers()
	{
		return new ResponseEntity<List<PackageOffers>>(ps.findAllBysimScheme(Scheme.POSTPAID),HttpStatus.OK);
	}

}