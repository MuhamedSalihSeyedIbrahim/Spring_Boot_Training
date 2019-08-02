package com.cts.sbwmd.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.PackageDetail;
import com.cts.sbwmd.model.PackageOffers;
import com.cts.sbwmd.model.Scheme;
import com.cts.sbwmd.model.customer;
import com.cts.sbwmd.service.CustomerService;
import com.cts.sbwmd.service.PackageServiceImp;

@Controller
@Scope("session")
public class appController {
	
	private customer customerSession;
	
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
			customerSession=customerKyc;
			return new ModelAndView("PackageOfferPageSelectionFrom","OfferData",ps.findAllBysimScheme(customerKyc.getSimScheme()));
	}
	
	@GetMapping("/saveCustomer")
	public ModelAndView SaveCustomerWithPackageHandler( @RequestParam(name="id")Long id ) {
		PackageOffers po=ps.findById(id);
		PackageDetail pd=customerSession.getPackageDetailChoosed();
		
		if(po!=null) {
			pd.setCost(po.getCost());
			pd.setDescription(po.getDescription());
			pd.setPlanID(po.getId());
			pd.setSubscriptionStartDate(LocalDate.now());
			pd.setSubscriptionStartDate((LocalDate.now()).plusDays(po.getValidityPeriod()));
			return new ModelAndView("Report","Detail",customerSession);
		}else {
			return new ModelAndView("/KycFormPage","cus",customerSession);
		}

	}

	
	
}
