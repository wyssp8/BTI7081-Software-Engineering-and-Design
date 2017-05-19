package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.List;


public class SettingsViewModel {

	//The list contacts will be imported from the contactModel 
	private List<Contact> contacts;
	
	private Contact eContact1;
	private Contact eContact2;
	private Contact eContact3;

	
	private String login;
	private String password;
	
	
	public SettingsViewModel() {
		
		login ="JohnDoe";
		password ="BFHBFH";
		
	}

	public Contact geteContact1() {
		return eContact1;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
