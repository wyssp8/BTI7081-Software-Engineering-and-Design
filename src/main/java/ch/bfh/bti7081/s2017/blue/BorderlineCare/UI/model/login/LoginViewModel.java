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

	}

	public LoginAccount getLoginAccount() {
		return this.loginAccount;
	}
	
//		for(LoginAccount login :loginAccount){
//			System.out.println(login.getEmail()+"\n"+login.getPassword()+"\n");
//		}

	public void setLoginAccount(LoginAccount loginAccount) {
		this.loginAccount = loginAccount;
	}


	


	

	
	
	
}
