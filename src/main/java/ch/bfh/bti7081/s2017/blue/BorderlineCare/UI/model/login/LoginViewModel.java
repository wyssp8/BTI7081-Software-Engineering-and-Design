package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;

/**
 * @author cpolo
 *
 */
public class LoginViewModel {
	
//	private String firstName;
//	private String lastName;
//	private String street;
//	private String zipCode;
//	private String city;
//	private String email;
//	private String password;
//	private String passwordConfirmation;
	private DBConnector dbConnector; 
	
	private LoginAccount loginAccount;
	
	public LoginViewModel(){
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
	}

	//Laden der Accounttabelle der Datenbank
	public LoginAccount getLoginAccount() {
		return this.loginAccount;
	}
	
	//Speicher auf Accounttabelle der Datenbank
	public void setLoginAccount(LoginAccount loginAccount) {
		this.loginAccount = loginAccount;
		System.out.println(loginAccount.getEmail()+"\n"+loginAccount.getPassword()+"\n");
	}
	
	public void setLoginAccountEmail(String email) {
		DBConnector.getDBConnector().setAccountEmail(email);
		System.out.println(loginAccount.getEmail()+"\n"+loginAccount.getPassword()+"\n");
	}
	
	

	


	

	
	
	
}
