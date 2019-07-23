package in.tp.scd.app;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tp.scd.BeanConfiguration.BeanConfiguration;
import in.tp.scd.service.GreetService;
import in.tp.scd.service.GreetServiceArgumentedImp;
import in.tp.scd.service.GreetSreviceAdvancedImp;


public class App1  {

	private static ApplicationContext context;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//service to create bean using annotation
		System.out.println((LocalDate) context.getBean("today"));
		
		//value configuration properties 
		GreetService gs2=(GreetService) context.getBean("gs2");
		System.out.println(gs2.greet("bean"));
		
		//autowire example
		GreetService gs3=(GreetService) context.getBean(GreetSreviceAdvancedImp.class);
		System.out.println(gs3.greet("bean"));
	
	}

}



