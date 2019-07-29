package com.cts.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.KYC;



@Controller

@Scope("session")
public class SubscriptionController {
 private KYC kycDetailsForSession;

 @ModelAttribute
	public void populateCommonModels(Model model) {
		model.addAttribute("options", new String[] { "Option1", "Option2", "Option3" });
	}
 
	@GetMapping("/client_KYC")
	public ModelAndView showEmpInput() {
		return new ModelAndView("KycInputPage","client_KYC",new KYC());
	}
	
	
	@PostMapping("/client_KYC")
	public ModelAndView showEmpOutput(@ModelAttribute("client_KYC") KYC kyc_client) {
		kyc_client.customerIdGenrator();
		kycDetailsForSession=kyc_client;
		return new ModelAndView("KycOutputPage","client_KYC",kyc_client);
	}
	
	@GetMapping("/packageSelection")
	public ModelAndView setPackageForUser() {
		return new ModelAndView("packageSelectionPage","client_KYC",kycDetailsForSession);
	}
	
	@GetMapping("/setPackage")
	public ModelAndView finalReportOutput (@RequestParam("packageDetails") String pkgName) {
		kycDetailsForSession.setPackageDetails(pkgName);
		return new ModelAndView("finalPageReport","client_KYC",kycDetailsForSession);
	}
	
	
	
}