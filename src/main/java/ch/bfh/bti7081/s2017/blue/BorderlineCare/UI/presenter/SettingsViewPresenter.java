package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.ArrayList;

import com.vaadin.navigator.Navigator;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

/**
 * @author André
 *
 */
public class SettingsViewPresenter {

	private SettingsViewImpl settingsView;
	private SettingsViewModel settingsModel;


	public SettingsViewPresenter(SettingsViewModel settingsModel, SettingsViewImpl settingsView, ContactModel contacts,
			LoginViewModel account, Navigator navigator) {

		this.settingsView = settingsView;
		this.settingsModel = settingsModel;

		settingsView.setNavigator(navigator);   // so we can return to the loginScreen by pressing the logout button
												 
		loadContacts();
		
		/**
		 * initialize settings text fields with LoginAccount information
		 */									
		settingsView.getLoginTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getEmail());
		settingsView.getPasswordTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getPassword());
		settingsView.getFirstNAmeTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getFirstName());
		settingsView.getLastNameTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getLastName());
		settingsView.getStreetTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getStreet());
		settingsView.getCityTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getCity());
		settingsView.getZipCodeTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getZipCode());

		/**
		 * edit and save change on the account settings 
		 * 
		 */
		settingsView.getBtEdit().addClickListener(e ->

		{
			settingsView.getEmailTextField().setEnabled(true);
			settingsView.getFirstNameTextField().setEnabled(true);
			settingsView.getLastNameTextField().setEnabled(true);
			settingsView.getStreetTextField().setEnabled(true);
			settingsView.getZipCodeTextField().setEnabled(true);
			settingsView.getCityTextField().setEnabled(true);
			settingsView.getPasswordTextField().setEnabled(true);

			if (settingsView.getBtEdit().getCaption().equals("Edit")) {
				settingsView.getBtEdit().setCaption("Save");
			} else {
				settingsView.getBtEdit().setCaption("Edit");

				// disable fields
				settingsView.getEmailTextField().setEnabled(false);
				settingsView.getFirstNameTextField().setEnabled(false);
				settingsView.getLastNameTextField().setEnabled(false);
				settingsView.getStreetTextField().setEnabled(false);
				settingsView.getZipCodeTextField().setEnabled(false);
				settingsView.getCityTextField().setEnabled(false);
				settingsView.getPasswordTextField().setEnabled(false);
				
//				save changes to the databank
				settingsModel.getDbConnector().getLoginAccount().setEmail(settingsView.getEmailTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setFirstName(settingsView.getFirstNAmeTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setLastName(settingsView.getLastNameTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setEmail(settingsView.getEmailTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setStreet(settingsView.getStreetTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setZipCode(settingsView.getZipCodeTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setCity(settingsView.getCityTextField().getValue());
				settingsModel.getDbConnector().getLoginAccount().setPassword(settingsView.getPasswordTextField().getValue());
			}

		});

		/**
		 * Ok button to save new emergency contacts
		 */
		settingsView.getBtEContSave().addClickListener(e -> {
			
			
			if (settingsView.getBtEContSave().getCaption().equals("Edit")) {
				settingsView.getBtEdit().setCaption("Save");

				settingsView.geteContact1Menu().setEnabled(true);
				settingsView.geteContact2Menu().setEnabled(true);
				settingsView.geteContact3Menu().setEnabled(true);

			} else {
				settingsView.getBtEdit().setCaption("Edit");

			settingsView.geteContact1Menu().setEnabled(false);
			settingsView.geteContact2Menu().setEnabled(false);
			settingsView.geteContact3Menu().setEnabled(false);

			// set the chosen conatcts to the eContacts1,2,3 on the DB
//			 settingsModel.getDbConnector().getLoginAccount().eContact1 = settingsView.geteContact1Menu().getValue();
//			 settingsModel.getDbConnector().getLoginAccount().eContact2 = settingsView.geteContact2Menu().getValue();
//			 settingsModel.getDbConnector().getLoginAccount().eContact3 = settingsView.geteContact3Menu().getValue();
//			settingsModel.getDbConnector().REFRESH	
			}
		});


	}

		/**
		 * load contatcs on the dropdown menu Emergency contacs
		 */
	public void loadContacts() {

		settingsView.geteContact1Menu().setItems(settingsModel.getDbConnector().getLoginAccount().getContacts());
		settingsView.geteContact2Menu().setItems(settingsModel.getDbConnector().getLoginAccount().getContacts());
		settingsView.geteContact3Menu().setItems(settingsModel.getDbConnector().getLoginAccount().getContacts());

		// Use the name property for item captions
		settingsView.geteContact1Menu().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact2Menu().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact3Menu().setItemCaptionGenerator(Contact::getName);

	}

}
