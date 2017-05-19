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
	
	private List<LoginAccount> loginAccounts;
	
	public LoginViewModel(){
		loginAccounts = new ArrayList<>();
		loginAccounts.add(new LoginAccount(
				"Claudio",						//First Name
				"Polo",							//Last Name
				"Panoramastrasse 3",			//Street
				"3600", 						//Zip Code
				"Thun", 						//City
				"polo@test.com",				//Email
				"test", 						//Password
				"null"));							//Password Confirmation
		
	}
	
	
	public List<LoginAccount> getLoginAccount(){
		return this.loginAccounts;
	}

}
