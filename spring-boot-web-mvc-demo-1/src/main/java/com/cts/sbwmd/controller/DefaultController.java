package com.cts.sbwmd.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	@GetMapping({"","/","/home"})
	public ModelAndView showHomePage() {
		return new ModelAndView("index","msg","Welcome All, This is SpringBoot WebApp");
	}
}
