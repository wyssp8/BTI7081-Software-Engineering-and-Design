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

	public Contact(String name, int phoneNumber, LoginAccount loginAccount) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.loginAccount = loginAccount;
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
	
	public LoginAccount getLoginAccount(){
		return this.loginAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((loginAccount == null) ? 0 : loginAccount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + phoneNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id != other.id)
			return false;
		if (loginAccount == null) {
			if (other.loginAccount != null)
				return false;
		} else if (!loginAccount.equals(other.loginAccount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

}
