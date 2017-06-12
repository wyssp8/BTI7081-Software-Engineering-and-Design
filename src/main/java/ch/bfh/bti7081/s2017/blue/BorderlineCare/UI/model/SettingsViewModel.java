package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;


import java.util.logging.Level;
import java.util.logging.Logger;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
/**
 * @author André
 *
 */
public class SettingsViewModel {

	
	private final static Logger logger = Logger.getLogger(ContactModel.class.getName());
	
	private DBConnector dbConnector;
	
	// fazer esses contatdos em uma lista com uma numero fixo que pode-se mudar mais tarde.
	private Contact eContact1;
	private Contact eContact2;
	private Contact eContact3;
	
	

	
//Assim se puxa infromaçôes dos logins na datenbank.
	public SettingsViewModel(){
		dbConnector = DBConnector.getDBConnector();

		//		dbConnector.getLoginAccount().getContacts();
	}

	

	public Contact geteContact1() {
		return eContact1;
	}


	public void seteContact1(Contact eContact1) {
		this.eContact1 = eContact1;
	}


	public Contact geteContact2() {
		return eContact2;
	}


	public void seteContact2(Contact eContact2) {
		this.eContact2 = eContact2;
	}


	public Contact geteContact3() {
		return eContact3;
	}


	public void seteContact3(Contact eContact3) {
		this.eContact3 = eContact3;
	}


	public DBConnector getDbConnector() {
		return dbConnector;
	}


	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	public String getCallLink() throws Exception {
		if(geteContact1() == null){
			throw new Exception("No emergency contact defined");
		}
		String phoneNumber = Integer.toString(geteContact1().getPhoneNumber());
		String fullLink = "tel:" + phoneNumber;
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}

	public String getMessageLink() throws Exception {
		if(geteContact1() == null){
			throw new Exception("No emergency contact defined");
		}
		String phoneNumber = Integer.toString(geteContact1().getPhoneNumber());
		String body = "I need help.";
		String fullLink = "sms://" + phoneNumber + "?body=" + body; 
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}



}
