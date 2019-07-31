package com.cts.sbcrud.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbcrud.service.EmployeeService;
import com.cts.sbcrud.model.Department;
import com.cts.sbcrud.model.Employee;

@Controller
public class EmployeeController {
	public final static int SAVED = 1, DELETED = 2,INSERTED=3;

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
	

	@GetMapping("/newEmps")
	public ModelAndView newEmpRequestHandler() {
		return new ModelAndView("empFormPage","emp",new Employee());
	
	}
	

	@PostMapping("/newEmps")
	public ModelAndView newEmpInserter( @RequestParam(name="id" ,required = false,defaultValue="-1") Long id,@Valid @ModelAttribute("emp") Employee emp, BindingResult  res )
	{
		ModelAndView mv;
		System.out.println("45666----------------------------------------------------------------------------");
		if(res.hasErrors())
		{
			System.out.println("effvf----------------------------------------------------------------------------");
			mv=new ModelAndView("empFormPage","emp",emp);
		}else{
			empService.save(emp);
			mv=new ModelAndView("redirect:/home?id="+emp.getEmpId()+"&msgCode="+INSERTED);
			
		}
		return mv;
	}
	

	@GetMapping("/deleteEmps")
	public ModelAndView deleteEmp(@RequestParam(name="empId") Long empId) {
			empService.deleteById(empId);
			return new ModelAndView("redirect:/home?id=" + empId + "&msgCode=" + DELETED);
	}
	
	
	@GetMapping("/editEmp")
	public ModelAndView editEmp(@RequestParam(name="id") Long id)
	{
		return new ModelAndView("empFormPage","emp",empService.findById(id));
	}

	@PostMapping("/editEmp")
	public ModelAndView newEmpAdd(@ModelAttribute("emp") Employee emp)
	{
		empService.save(emp);
		return new ModelAndView("redirect:/home?id="+emp.getEmpId()+"&msgCode="+SAVED);
	}

	@GetMapping("/details")
	public ModelAndView empDetailsShowPage(@RequestParam Long empId) {
		return new ModelAndView("empDetailsShowPage", "emp", empService.findById(empId));
	}
	
	
	
	@GetMapping("/searchEmp")
	public ModelAndView searchEmp()
	{
		return new ModelAndView("searchEmp","data",null);
	}
	



	
	@GetMapping("/findData")
	public ModelAndView findData(@RequestParam(name="search" ,required = true) String find,
			@RequestParam(name="inputval" ,required = true) String input,
			@RequestParam(name="inputval1" , required = false) String val)
	{
		ModelAndView mv = new ModelAndView("searchEmp");
		
		if(find.equals("Id"))
		{
			mv.addObject("data", empService.findById(Long.parseLong(input)));
			mv.addObject("check",1);
		}
		else if(find.equals("EmailId"))
		{
			mv.addObject("data", empService.findIdByemailid(input));
			mv.addObject("check",1);
		}
		else if(find.equals("Mobileno"))
		{
			mv.addObject("data", empService.findBymobileNumber(input));
			mv.addObject("check",1);
		}
		else if(find.equals("Department"))
		{
			System.out.println(empService.findAllByDept(Department.valueOf(input)));
			mv.addObject("data", empService.findAllByDept(Department.valueOf(input)));
			mv.addObject("check",2);
		}
		else if(find.equals("JoiningDate"))
		{
			mv.addObject("data",empService.findAllByjoinDate(LocalDate.parse(input)));
			mv.addObject("check",2);
		}
		else if(find.equals("Basic"))
		{
			mv.addObject("data",empService.findAllByBasicRange(Double.parseDouble(input), Double.parseDouble(val)));
			mv.addObject("check",2);
		}
			
		return mv;
	}
	
	
	
}
