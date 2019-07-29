package com.cts.sbwmd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceTimeBasedImp implements GreetService {

	@Override
	public String getGreeting() {
		int h= LocalTime.now().getHour() ;
		String greeting=null;
		if(h>1&&h<12) greeting="Good day!!";
		else greeting="Good Night!!";
		return greeting;
	}

}
