package in.tp.scrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.tp.scrud.model.Employee;
import in.tp.scrud.service.IEmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/list")
	public ModelAndView listEmploees() {		
		return new ModelAndView("empList", "emps",empService.listEmployees());
	}
	
	@GetMapping("/add")
	public ModelAndView addEmploee() {
		return new ModelAndView("addEmp", "emp",new Employee());
	}
	
	@PostMapping("/add")
	public String doAddEmploee(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/listEmps";
	}
}
