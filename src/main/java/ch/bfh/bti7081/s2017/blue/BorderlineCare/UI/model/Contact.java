package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

public class Contact {
	
	private String name;
	private int phoneNumber;
	
	public Contact(String name, int phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;		
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
