package com.cts.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crud.Model.Postpaid;
import com.cts.crud.Model.PrepaidOffers;
import com.cts.crud.Service.PostpaidService;
import com.cts.crud.Service.PrepaidService;

@RestController
@RequestMapping("/Offers")
public class OfferController {
	
	@Autowired
	private PrepaidService pre;
	
	@Autowired
	private PostpaidService post;
	
	@GetMapping("/prepaid")
	public ResponseEntity<List<PrepaidOffers>> getPrepaidOffers()
	{
		return new ResponseEntity<List<PrepaidOffers>>(pre.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/postpaid")
	public ResponseEntity<List<Postpaid>> getPostpaidOffers()
	{
		return new ResponseEntity<List<Postpaid>>(post.findAll(),HttpStatus.OK);
	}

}
