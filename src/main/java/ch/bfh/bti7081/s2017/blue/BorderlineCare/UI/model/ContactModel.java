package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
	
	private List<Contact> contacts;
	
	public ContactModel(){
		contacts = new ArrayList<>();
		contacts.add(new Contact("Sandro", 12345));
		contacts.add(new Contact("André", 23456));
		contacts.add(new Contact("Patrick", 34567));
		contacts.add(new Contact("Martin", 45678));
		contacts.add(new Contact("Joel", 56789));
		contacts.add(new Contact("Polo", 67891));
		
		
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void remove(Contact contact) {
		contacts.remove(0);
	}

}
