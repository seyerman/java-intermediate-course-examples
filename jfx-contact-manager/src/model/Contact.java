package model;

public class Contact {
	private String name;
	private String email;
	
	public Contact(String na, String em) {
		name = na;
		email = em;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}	
}
