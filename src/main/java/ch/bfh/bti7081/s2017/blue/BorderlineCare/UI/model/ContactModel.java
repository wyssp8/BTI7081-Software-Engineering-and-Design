package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
	
	private List<Contact> contacts;
	
	public ContactModel(){
		contacts = new ArrayList<>();
		contacts.add(new Contact("Sandro", 12345));
		
	}
	
	public List<Contact> getContacts(){
		return this.contacts;
	}

}
