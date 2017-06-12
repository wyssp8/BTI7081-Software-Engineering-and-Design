package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;

/**
 * @author cpolo
 * The model for the LoginView. In here are all interactions between the database and
 * the borderlineCare app regarding the login account
 *
 */
public class LoginViewModel {

	private DBConnector dbConnector; 
	private LoginAccount loginAccount;
	
	public LoginViewModel(){
	}

	//Laden der Accounttabelle der Datenbank
	public LoginAccount getLoginAccount() {
		return DBConnector.getDBConnector().getLoginAccount();
	}
	
	//Speicher auf Accounttabelle der Datenbank
	public void setLoginAccount(LoginAccount loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public void setLoginAccountEmail(String email) {
		DBConnector.getDBConnector().setAccountEmail(email);
	}
	
	public void addNewLoginAccount(LoginAccount loginAccount){
		DBConnector.getDBConnector().addNewLoginAccountToDB(loginAccount);
	}
}
