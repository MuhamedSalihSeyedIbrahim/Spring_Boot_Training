package com.cts.sbcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbcrud.service.EmployeeService;
import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;

@Controller
public class EmployeeController {
	public final static int SAVED = 1, DELETED = 2;

	@Autowired
	private EmployeeService empService;

	@ModelAttribute
	public void populateCommonData(Model model) {
		model.addAttribute("depts", Department.values());
	}

	@GetMapping("/emps")
	public ModelAndView empListPageRequestHandler() {
		return new ModelAndView("empListPage", "emp", empService.findAll());
	}

	@GetMapping({"/newEmps","/editEmps"})
	public ModelAndView newEmpRequestHandler(@RequestParam(name="empId",defaultValue = "-1",required=false) Long empId) {
		
		if(empId ==-1)
			return new ModelAndView("empFormPage","emp",new Employee());
		else
			return new ModelAndView("empFormPage","emp",empService.findById(empId));
	}


	@GetMapping("/deleteEmps")
	public ModelAndView deleteEmp(@RequestParam(name="empId") Long empId) {
			empService.deleteById(empId);
			return new ModelAndView("redirect:/home?id=" + empId + "&msgCode=" + DELETED);
	}
	
	@PostMapping("/newEmps")
	public ModelAndView saveEmpRequestHandler(@Valid @ModelAttribute("emp") Employee emp, BindingResult results) {

		ModelAndView mv;
		if (results.hasErrors()) {
			mv = new ModelAndView("empFormPage", "emp", emp);
		} else {

			System.out.println(emp.getFirstName());
			empService.save(emp);
			long empId = emp.getEmpId();
			mv = new ModelAndView("redirect:/home?id=" + empId + "&msgCode=" + SAVED);
		}
		return mv;
	}

	@GetMapping("/searchEmp")
	public ModelAndView searchEmpRequestHandler() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@GetMapping("/details")
	public ModelAndView empDetailsShowPage(@RequestParam Long empId) {
		return new ModelAndView("empDetailsShowPage", "emp", empService.findById(empId));
	}
}
