package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.log.Log;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class ContactModel {
	
	private List<Contact> contacts;
	
	public ContactModel(){
		contacts = new ArrayList<>();
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		for (Contact contact : loginAccount.getContacts()) {
			contacts.add(contact);
		}
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}
}
