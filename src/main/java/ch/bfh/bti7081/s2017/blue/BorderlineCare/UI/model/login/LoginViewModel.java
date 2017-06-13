package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;

/**
 * The model for the LoginView. In here are all interactions between the database and
 * the borderlineCare app regarding the login account
 * @author cpolo
 *
 */
public class LoginViewModel {

	public LoginViewModel(){
	}

	//Laden der Accounttabelle der Datenbank
	public LoginAccount getLoginAccount() {
		return DBConnector.getDBConnector().getLoginAccount();
	}
	
	//Speicher auf Accounttabelle der Datenbank
	public void setLoginAccount(LoginAccount loginAccount) {
		DBConnector.getDBConnector().addNewLoginAccountToDB(loginAccount);
	}
	
	public void setLoginAccountEmail(String email) {
		DBConnector.getDBConnector().setAccountEmail(email);
	}
	
}
