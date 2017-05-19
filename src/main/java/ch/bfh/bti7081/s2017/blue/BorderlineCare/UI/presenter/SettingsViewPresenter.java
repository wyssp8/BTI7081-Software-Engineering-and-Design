package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

public class SettingsViewPresenter {

	private SettingsViewImpl settingsView;
	private SettingsViewModel settingsModel;
	private ContactModel contacts;

	public void loadContacts() {
		
		
		settingsView.geteContact1().setItems(contacts.getContacts());
		settingsView.geteContact2().setItems(contacts.getContacts());
		settingsView.geteContact3().setItems(contacts.getContacts());

		// Use the name property for item captions
		settingsView.geteContact1().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact2().setItemCaptionGenerator(Contact::getName);
		settingsView.geteContact3().setItemCaptionGenerator(Contact::getName);

	}

	public SettingsViewPresenter(SettingsViewModel settingsModel, SettingsViewImpl settingsView,
			ContactModel contacts) {
		this.settingsView = settingsView;
		this.settingsModel = settingsModel;
		this.contacts = contacts;

	

		/**
		 * initialize Login and Pass
		 */
		settingsView.getLogin().setValue(settingsModel.getLogin());
		settingsView.getPassword().setValue(settingsModel.getPassword());

		/**
		 * Load contacts into ViewImpl object
		 */
		loadContacts();

	}

	/**
	 * Save eContacts
	 */
	public void saveEContacts(Contact c1, Contact c2, Contact c3) {
		settingsModel.seteContact1(c1);
		settingsModel.seteContact2(c2);
		settingsModel.seteContact3(c3);
	}

}
