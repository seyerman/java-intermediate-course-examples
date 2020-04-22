package model;

import java.util.List;
import java.util.ArrayList;

public class ContactManager {
	private List<Contact> contacts;
	
	public ContactManager() {
		contacts = new ArrayList<>();
	}
	
	public void addContact(String na, String em) {
		contacts.add(new Contact(na, em));
	}
	
	public List<Contact> getContacts(){
		return contacts; 
	}
}
