package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

public class SettingsViewModel {

	private String eContact1;
	private String eContact2;
	private String eContact3;
	
	private String login;
	private String password;
	
	public SettingsViewModel() {
		eContact1 = "079 555 666 777";
		eContact2 = "077 222 333 444";
		eContact3 = "076 999 888 777";
		login ="JohnDoe";
		password ="BFHBFH";
		
	}

	public String geteContact1() {
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

	public void seteContact1(String eContact1) {
		this.eContact1 = eContact1;
	}

	public String geteContact2() {
		return eContact2;
	}

	public void seteContact2(String eContact2) {
		this.eContact2 = eContact2;
	}

	public String geteContact3() {
		return eContact3;
	}

	public void seteContact3(String eContact3) {
		this.eContact3 = eContact3;
	}

}
