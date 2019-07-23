
package in.tp.scd.service;

public class GreetServiceArgumentedImp implements GreetService {
	
	public GreetServiceArgumentedImp(String greetNote) {
		
		this.greetNote = greetNote;
	}
	private String greetNote;
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
