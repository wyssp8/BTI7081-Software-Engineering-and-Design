package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private int phoneNumber;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LOGINACCOUNT_EMAIL")
	private LoginAccount loginAccount;
	
	public Contact() {
	}

	public Contact(int id, String name, int phoneNumber) {
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
