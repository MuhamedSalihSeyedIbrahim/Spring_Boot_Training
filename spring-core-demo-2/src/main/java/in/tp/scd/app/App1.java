package in.tp.scd.app;

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
		
		GreetService gs1=(GreetService) context.getBean("gs1");
		System.out.println(gs1.greet("Hai bean config"));
			
		GreetService gs2=(GreetService) context.getBean("gs2");
		System.out.println(gs2.greet("Hai bean config@ constructor injection"));
		
		GreetService gs3=(GreetService) context.getBean("gs3");
		System.out.println(gs3.greet("Hai bean config@ setter injection"));
			
			
	}

}



