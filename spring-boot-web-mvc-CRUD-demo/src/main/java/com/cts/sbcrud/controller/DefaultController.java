package com.cts.sbcrud.controller;

import java.util.*;

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
	@ModelAttribute
	public void populateCommonData(Model model) {
		Map<String, String> navLinks = new LinkedHashMap<String, String>();
		navLinks.put("home", "Home");
		navLinks.put("emps", "Employees");
		navLinks.put("newEmps", "New Employees");
		navLinks.put("searchEmp", "Search Employees");
		model.addAttribute("link", navLinks);
		model.addAttribute("appTitle", appTitle);

	}

	@Value("#{${app.title}}")
	private String appTitle;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView homePageRequestHandler(
			@RequestParam(name = "msgCode", required = false, defaultValue = "0") int msgCode,
			@RequestParam(name = "id", required = false, defaultValue = "0") long empId) {
		ModelAndView mv = new ModelAndView("dashboardPage");
		if (msgCode > 0) {
			if(msgCode ==EmployeeController.SAVED)
				mv.addObject("msg", "Employee# " + empId + " is Saved  SUCCESSFULLY");
			else if(msgCode ==EmployeeController.DELETED)
				mv.addObject("msg", "Employee# " + empId + " is Deleted SUCCESSFULLY");
			else if(msgCode == EmployeeController.INSERTED)
			mv.addObject("msg", "Employee# " + empId + " is Inserted SUCCESSFULLY");
		}
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
