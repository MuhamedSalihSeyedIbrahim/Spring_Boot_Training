package in.tp.scd.service;
public class GreetSreviceAdvancedImp implements GreetService  {
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
