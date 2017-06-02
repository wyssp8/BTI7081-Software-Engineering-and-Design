package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.List;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
/**
 * @author André
 *
 */
public class SettingsViewModel {

	
	private DBConnector dbConnector;
	
	
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
	



}
