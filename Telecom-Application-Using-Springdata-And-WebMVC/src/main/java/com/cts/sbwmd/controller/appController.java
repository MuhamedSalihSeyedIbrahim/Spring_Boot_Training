package com.cts.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.model.customer;
import com.cts.sbwmd.service.CustomerService;
import com.cts.sbwmd.service.PackageServiceImp;

@Controller
@Scope("session")
public class appController {
	
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private PackageServiceImp ps;
	
	@GetMapping("/KycFormPage")
	public ModelAndView homePageRequestHandler() {
		ModelAndView mv = new ModelAndView("KycFormPage","cus", new customer());
		return mv;
	}
	
	@PostMapping("/KycFormPage")
	public ModelAndView KycDetailInputFormRequestHandler( @ModelAttribute(name="cus") customer customerKyc) {
		
			System.out.print(ps.findAllBysimScheme(customerKyc.getSimScheme()).toString());
			return new ModelAndView("PackageOfferPageSelectionFrom","OfferData",null);//ps.findAllBysimScheme(customerKyc.getSimScheme()));
	}
	
	@GetMapping("/saveCustomer")
	public ModelAndView SaveCustomerWithPackageHandler( @RequestParam(name="pkgDetails") )
	
	
}
