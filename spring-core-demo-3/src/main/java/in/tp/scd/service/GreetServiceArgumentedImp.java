
package in.tp.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gs2")
public class GreetServiceArgumentedImp implements GreetService {
	
	// "$<{string>:<Default String>}" --> spring expression language
	
	//@Value("ggggg")
	@Value("${greetNote:Hai}")
	private String greetNote;
	
	
	public GreetServiceArgumentedImp() {
		
	}
	
	public GreetServiceArgumentedImp(String greetNote) {
		super();
		this.greetNote = greetNote;
	}
	
	public String greet(String UserName) {
		StringBuilder sb = new StringBuilder(greetNote !=null?greetNote: "Hello");
		sb.append(UserName);
		return sb.toString();
		
	}
	
	public String getGreetNote() {
		return greetNote;
	}
	public void setGreetNote(String greetNote) {
		this.greetNote = greetNote;
	}

}
