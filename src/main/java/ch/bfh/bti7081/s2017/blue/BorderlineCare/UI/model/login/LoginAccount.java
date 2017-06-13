package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.CalmDownExercise;
/**
 * Login Account object
 * @author cpolo
 *
 */
@Entity
public class LoginAccount {
	
	@Id
	private String email;
	
	private String firstName;
	private String lastName;
	private String street;
	private String zipCode;
	private String city;
	private String password;
	
	@OneToMany(mappedBy = "loginAccount", cascade=CascadeType.PERSIST)
	private Set<CalmDownExercise> calmDownExercises;
	@OneToMany(mappedBy = "loginAccount", cascade=CascadeType.PERSIST)
	private Set<Contact> contacts;
	@OneToMany(mappedBy = "loginAccount", cascade=CascadeType.PERSIST)
	private Set<DiaryEntry> diaryEntries;
	
	@OneToOne(mappedBy = "loginAccount", cascade=CascadeType.PERSIST)
	private SettingsViewModel settingsViewModel;
	
	public LoginAccount(){
	}
	
	public LoginAccount(String firstName, String lastName, String street, String zipCode, String city, String email,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.email = email;
		this.password = password;
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

	public Set<CalmDownExercise> getCalmDownExercises() {
		return calmDownExercises;
	}

	public void setCalmDownExercises(Set<CalmDownExercise> calmDownExercises) {
		this.calmDownExercises = calmDownExercises;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<DiaryEntry> getDiaryEntries() {
		return diaryEntries;
	}

	public void setDiaryEntries(Set<DiaryEntry> diaryEntries) {
		this.diaryEntries = diaryEntries;
	}

	public SettingsViewModel getSettingsViewModel() {
		return settingsViewModel;
	}

	public void setSettingsViewModel(SettingsViewModel settingsViewModel) {
		this.settingsViewModel = settingsViewModel;
	}
	
}
