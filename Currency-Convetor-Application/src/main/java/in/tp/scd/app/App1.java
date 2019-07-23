package in.tp.scd.app;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tp.scd.BeanConfiguration.BeanConfiguration;
import in.tp.scd.service.Conversion;
import in.tp.scd.service.ConversionServiceImp;



public class App1  {

	private static ApplicationContext context;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		ConversionServiceImp gs3=(ConversionServiceImp) context.getBean("gs");
		System.out.println(gs3.CovertOperation(1000.0,"POUND","RAND"));

	}

}



