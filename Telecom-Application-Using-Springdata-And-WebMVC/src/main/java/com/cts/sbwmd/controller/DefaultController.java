package com.cts.sbwmd.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DefaultController {
	
	@Value("#{${app.title}}")
	private String appTitle;
	
	@ModelAttribute
	public void populateCommonData(Model model) {
		Map<String, String> navLinks = new LinkedHashMap<String, String>();
		navLinks.put("Home", "Home");
		navLinks.put("KycFormPage","New Subscriber!");
		model.addAttribute("link", navLinks);
		model.addAttribute("appTitle", appTitle);

	}
	
	
	@GetMapping({ "", "/", "/Home" })
	public ModelAndView homePageRequestHandler() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;
	}
	
	

	@RequestMapping("/header")
	public ModelAndView headerSectionRequestHAndler() {

		ModelAndView mv = new ModelAndView("headerSection");

		return mv;
	}

	@GetMapping("/footer")
	public ModelAndView footerSectionRequestHAndler() {
		return new ModelAndView("footerSection");
	}
	
}
