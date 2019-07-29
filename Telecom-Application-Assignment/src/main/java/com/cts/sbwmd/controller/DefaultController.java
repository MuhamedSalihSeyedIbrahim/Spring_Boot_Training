package com.cts.sbwmd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@Value("#{${app.title}}")
	private String appTitle;
	
	@RequestMapping({"","/","home"})
	public ModelAndView defaultGetRequestHandler() {
		//return string which converted to { /pages/home.jsp }
		//return type is name of page and its string 
		//return "home";
		
		//constructor method
		//return new model and bind the data to "page title" dummy space in the jsp 
		//return new ModelAndView("home","pageTitle","Home page- Welcome All");
		
		
		//getter setter method
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		mv.addObject("pageTitle","Home page- Welcome All");
		mv.addObject("developer", new String[] {"Muhamed","Shanukh","Ashwin"});
		
		return mv;
	}
	
	@RequestMapping({"/header"})
	public ModelAndView getHeaderPage() {
		return new ModelAndView("header","appTitle",appTitle);
	}
	

	@RequestMapping({"/footer"})
	public String getFooterPage() {
		return "footer";
	}
}
