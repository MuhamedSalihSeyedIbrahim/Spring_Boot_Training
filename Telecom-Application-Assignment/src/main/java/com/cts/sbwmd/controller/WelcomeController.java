package com.cts.sbwmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.service.GreetService;

@Controller
public class WelcomeController {

	@Autowired(required=true)
	private GreetService greetService;
	
	@RequestMapping("/greet")
	public ModelAndView ShowGreet(@RequestParam(name="unm",required = false) String userName) {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("greet");
		
		if(userName!=null) {
			mv.addObject("greeting",greetService.getGreeting()+userName);
		}
		return mv;
		//return "greet";
	}
}
