package in.tp.scd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tp.scd.service.GreetService;
import in.tp.scd.service.GreetServiceArgumentedImp;
import in.tp.scd.service.GreetSreviceAdvancedImp;


public class App1  {

	private static ApplicationContext context;

	public static void main(String[] args) {
		//GreetService gs= new GreetServiceStandardImp();
				//System.out.println(gs.greet("Indhikaa"));
	
		context = new ClassPathXmlApplicationContext("beans1.xml");
		
		GreetService gs1= (GreetService)context.getBean("gs1");
		System.out.println(gs1.greet("Indhikaa"));
		

		GreetService gs3= (GreetServiceArgumentedImp)context.getBean("gs3");
		System.out.println(gs3.greet("constructor exmaple"));
		GreetService gs4= (GreetSreviceAdvancedImp)context.getBean("gs4");
		System.out.println(gs4.greet("constructor exmaple"));
		
		

	}

}



