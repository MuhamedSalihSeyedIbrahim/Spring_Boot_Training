
package in.tp.scd.service;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetNoteProviderTimeBasedImp implements GreetNoteProvider {

	private String greetNote;


	public String getGreetNote() {
		// TODO Auto-generated method stub
		int h=LocalTime.now().getHour();
		if(h>4&&h<=11 ) greetNote="greet 4 - 11";
		else greetNote="other";
		return greetNote;
	}

}
