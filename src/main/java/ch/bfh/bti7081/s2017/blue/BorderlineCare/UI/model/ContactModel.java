package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
	
	private List<Contact> contacts;
	
	public ContactModel(){
		contacts = new ArrayList<>();
		contacts.add(new Contact(1, "Sandro", 12345));
		contacts.add(new Contact(2, "André", 23456));
		contacts.add(new Contact(3, "Patrick", 34567));
		contacts.add(new Contact(4, "Martin", 45678));
		contacts.add(new Contact(5, "Joel", 56789));
		contacts.add(new Contact(6, "Polo", 67891));
		
		
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}



}
