package in.tp.scrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.tp.scrud.model.Employee;
import in.tp.scrud.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/listEmps")
	public ModelAndView listEmploees() {		
		return new ModelAndView("empList", "emps",empService.listEmployees());
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addEmploee() {
		return new ModelAndView("addEmp", "emp",new Employee());
	}
	
	@PostMapping("/addEmp")
	public String doAddEmploee(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/listEmps";
	}
}
