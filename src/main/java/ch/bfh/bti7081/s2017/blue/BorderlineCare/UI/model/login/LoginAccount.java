package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;

import java.util.List;

import com.vaadin.ui.TextField;

public class LoginAccount {
	
	private String firstName;
	private String lastName;
	private String street;
	private String zipCode;
	private String city;
	private String email;
	private String password;
	private String passwordConfirmation;
	
	public LoginAccount(String firstName, String lastName, String street, String zipCode, String city, String email,
			String password, String passwordConfirmation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}
