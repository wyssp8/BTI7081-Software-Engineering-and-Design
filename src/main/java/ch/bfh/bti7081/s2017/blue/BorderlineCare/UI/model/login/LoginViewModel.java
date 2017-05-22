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
	
	private List<LoginAccount> loginAccounts = new ArrayList<>();
	
	public LoginViewModel(){
		//Two dummy accounts
//		loginAccounts.add(new LoginAccount("Claudio", // First Name
//				"Polo", // Last Name
//				"Panoramastrasse 3", // Street
//				"3600", // Zip Code
//				"Thun", // City
//				"polo@test.com", // Email
//				"hallowelt")); // Password
//
//
//		loginAccounts.add(new LoginAccount("tester", // First Name
//				"Polo", // Last Name
//				"Panoramastrasse 3", // Street
//				"3600", // Zip Code
//				"Thun", // City
//				"test2@test.com", // Email
//				"test2")); // Password

	}

	public List<LoginAccount> getLoginAccounts() {
		return this.loginAccounts;
	}
	
	public void addLoginAccount(LoginAccount loginAccount){
		loginAccounts.add(loginAccount);
		
		for(LoginAccount login :loginAccounts){
			System.out.println(login.getEmail()+"\n"+login.getPassword()+"\n");
		}
	}


	


	

	
	
	
}
