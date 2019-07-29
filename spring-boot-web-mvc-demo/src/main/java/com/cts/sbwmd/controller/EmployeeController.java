package com.cts.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.Employee;
import com.cts.sbwmd.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@ModelAttribute
	public void populateCommonModels(Model model) {
		model.addAttribute("designations",new String[] {
				"PAT","PA","A","SA","ARCT","SARCT"
		});
	}
	
	
	@GetMapping
	public ModelAndView showEmpInput() {
		return new ModelAndView("empInputPage","emp",new Employee());
	}
	
	
	@PostMapping
	public ModelAndView showEmpOutput(@ModelAttribute("emp") Employee emp) {
		emp = empService.computeAllowences(emp);
		return new ModelAndView("empOutputPage","emp",emp);
	}
	
	
}