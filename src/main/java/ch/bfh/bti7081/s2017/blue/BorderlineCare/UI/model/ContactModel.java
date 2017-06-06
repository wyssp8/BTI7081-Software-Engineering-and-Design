package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class ContactModel {
	
	private Set<Contact> contacts;
	
	public ContactModel(){
		contacts = new HashSet<>();
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		for (Contact contact : loginAccount.getContacts()) {
			contacts.add(contact);
		}
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}
}
