package in.tp.scd.BeanConfiguration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import  org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;

import in.tp.scd.service.GreetServiceArgumentedImp;
import in.tp.scd.service.GreetServiceStandardImp;

@Configurable
public class BeanConfiguration {

	@Bean 
	public GreetServiceStandardImp gs1() {
		return new GreetServiceStandardImp();
	}
	
//	//constructor injection
	@Bean 
	public GreetServiceArgumentedImp gs2() {
		return new GreetServiceArgumentedImp(null);
	}

	//setter injection
		@Bean 
		public GreetServiceArgumentedImp gs3() {
			GreetServiceArgumentedImp obj =new GreetServiceArgumentedImp(null);
			//obj.setGreetNote("java bean config @ setter Injection");
			return obj;
		}
		
//	//bean ref passing
//		@Bean
//		public GreetNoteRoviderTimeBasedImp gs4() {
//			new GreetNotePRoviderTimeBasedImp(gs1);
//		}
		
}
