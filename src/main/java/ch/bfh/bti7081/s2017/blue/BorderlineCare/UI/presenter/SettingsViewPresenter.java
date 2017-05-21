package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

/**
 * @author André
 *
 */
public class SettingsViewPresenter {

	private SettingsViewImpl settingsView;
	private SettingsViewModel settingsModel;
	private ContactModel contacts;
	private LoginViewModel account;
	
	private ArrayList<Contact> eContacts = new ArrayList<>();

	public SettingsViewPresenter(SettingsViewModel settingsModel, SettingsViewImpl settingsView, ContactModel contacts,
		LoginViewModel account, Navigator navigator) {
		this.settingsView = settingsView;
		this.settingsModel = settingsModel;
		this.contacts = contacts;
		this.account = account;
		
		/**
		 * pass the navigator object on to the SettingsView object 
		 * (to go back to login screen on Logout button click)
		 */
		settingsView.setNavigator(navigator);

		/**
		 * Load contacts into ViewImpl object
		 */
		loadUserinfo();
		loadContacts();

		/**
		 * initialize settings text fields
		 */
		settingsView.loginTextField().setValue(settingsModel.getEmail());
		settingsView.getPasswordTextField().setValue(settingsModel.getPassword());
		settingsView.getFirstNAmeTextField().setValue(settingsModel.getFirstName());
		settingsView.getLastNameTextField().setValue(settingsModel.getLastName());
		settingsView.getStreetTextField().setValue(settingsModel.getStreet());
		settingsView.getCityTextField().setValue(settingsModel.getCity());
		settingsView.getZipCodeTextField().setValue(settingsModel.getZipCode());
		
	}
		/**
		 * load contatcs on the dropdown menu Emergency contacs
		 */
	public void loadContacts() {

		settingsView.geteContact1Menu().setItems(contacts.getContacts());
		settingsView.geteContact2Menu().setItems(contacts.getContacts());
		settingsView.geteContact3Menu().setItems(contacts.getContacts());

		// Use the name property for item captions
		settingsView.geteContact1Menu().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact2Menu().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact3Menu().setItemCaptionGenerator(Contact::getName);

	}
	/**
	 * load info of the logged user on the Account Settings
	 */
	public void loadUserinfo() {

		settingsModel.setEmail((account.getLoginAccount().get(0).getEmail()));
		settingsModel.setFirstName(account.getLoginAccount().get(0).getFirstName());
		settingsModel.setLastName(account.getLoginAccount().get(0).getLastName());
		settingsModel.setStreet(account.getLoginAccount().get(0).getStreet());
		settingsModel.setZipCode(account.getLoginAccount().get(0).getZipCode());
		settingsModel.setCity(account.getLoginAccount().get(0).getCity());
		settingsModel.setPassword(account.getLoginAccount().get(0).getPassword());
	}

	

}
