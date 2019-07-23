package in.tp.scd.service;
import org.springframework.stereotype.Service;
@Service("gs1")
public class GreetServiceStandardImp implements GreetService{
	
	public String greet(String userName) {
		

		return "Hello "+userName;
	}

}
