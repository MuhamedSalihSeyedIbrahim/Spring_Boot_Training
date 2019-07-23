package in.tp.scd.BeanConfiguration;

import java.time.LocalDate;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import in.tp.scd.*;
import in.tp.scd.service.GreetNoteProviderTimeBasedImp;
import in.tp.scd.service.GreetServiceArgumentedImp;

@Configuration
@ComponentScan(basePackages = {"in.tp.scd"})
@PropertySource(value= {"classpath:application.properties"})
public class BeanConfiguration {

	@Bean 
	LocalDate today() {
		return LocalDate.now();
	}
	


}
