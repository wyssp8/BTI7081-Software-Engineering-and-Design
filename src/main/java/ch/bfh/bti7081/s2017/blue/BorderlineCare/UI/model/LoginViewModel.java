package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel {
	
	private List<LoginAccount> loginAccounts;
	
	public LoginViewModel(){
		loginAccounts = new ArrayList<>();
		loginAccounts.add(new LoginAccount("Claudio","Polo","poloc1","test"));
		
	}
	
	
	public List<LoginAccount> getLoginAccount(){
		return this.loginAccounts;
	}

}
