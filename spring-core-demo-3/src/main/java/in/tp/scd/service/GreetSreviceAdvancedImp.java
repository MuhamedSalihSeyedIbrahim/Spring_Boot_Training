package in.tp.scd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetSreviceAdvancedImp implements GreetService  {
	@Autowired(required=false)
	private GreetNoteProvider gnp;

	public GreetNoteProvider getGnp() {
		return gnp;
	}

	public void setGnp(GreetNoteProvider gnp) {
		this.gnp = gnp;
	}

	public String greet(String UserName) {
		// TODO Auto-generated method stub
		return gnp.getGreetNote()+UserName;
			
	}

}
