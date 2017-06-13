package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;


import java.io.Serializable;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

/**
 * @author André
 *
 */

@Entity
public class SettingsViewModel implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -8164450806000217760L;
	@Transient
	private final static Logger logger = Logger.getLogger(ContactModel.class.getName());
	@Transient
	private DBConnector dbConnector;
	
	// fazer esses contatdos em uma lista com uma numero fixo que pode-se mudar mais tarde.
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CONTACT_ID")
	private Contact contact;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LOGINACCOUNT_EMAIL")
	private LoginAccount loginAccount; 
	
	public SettingsViewModel(){
		dbConnector = DBConnector.getDBConnector();
	}
	

	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public DBConnector getDbConnector() {
		return dbConnector;
	}

	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public String getCallLink() throws Exception {
		if(getContact() == null){
			throw new Exception("No emergency contact defined");
		}
		String phoneNumber = Integer.toString(getContact().getPhoneNumber());
		String fullLink = "tel:" + phoneNumber;
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}

	public String getMessageLink() throws Exception {
		if(getContact() == null){
			throw new Exception("No emergency contact defined");
		}
		String phoneNumber = Integer.toString(getContact().getPhoneNumber());
		String body = "I need help.";
		String fullLink = "sms://" + phoneNumber + "?body=" + body;
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}


/**
 * save all the edited user settings in the Datenbank 
 */
	public void saveUserSettignsToDB(
			String email, 
			String fName, 
			String lName, 
			String street,
			String zipCode, 
			String city, 
			String password, 
			Contact contact ) {

		 loginAccount.setEmail(email);
		 loginAccount.setFirstName(fName);
		 loginAccount.setLastName(lName);
		 loginAccount.setStreet(street);
		 loginAccount.setZipCode(zipCode);
		 loginAccount.setCity(city);
		 loginAccount.setPassword(password);
		 setContact(contact);
		
		
		dbConnector.writeDataToDB();

	}



}
