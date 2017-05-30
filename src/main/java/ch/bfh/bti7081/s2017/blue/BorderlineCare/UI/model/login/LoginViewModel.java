package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;

import java.util.ArrayList;
import java.util.List;

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
	
	private LoginAccount loginAccount;
	public LoginViewModel(){
		//loginAccount = new LoginAccount(null, null, null, null, null, null, null);
		
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


	


	

	
	
	
}
