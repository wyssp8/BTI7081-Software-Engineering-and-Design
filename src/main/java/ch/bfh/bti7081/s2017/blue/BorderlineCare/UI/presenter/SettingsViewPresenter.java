package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;
import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SettingsClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

/**
 * @author André
 *
 */
public class SettingsViewPresenter implements SettingsClickListener {
	
	private SettingsViewImpl settingsView;
	private SettingsViewModel settingsModel;
	private Navigator navigator;
	private UI ui = UI.getCurrent();

	public SettingsViewPresenter(SettingsViewModel settingsModel, SettingsViewImpl settingsViewImp, ContactModel contacts,
			Navigator navigator) {

		this.settingsView = settingsViewImp;
		this.settingsModel = settingsModel;
		this.navigator = navigator;
		
		initTextFields(settingsView);

		AccEditButtonClick(settingsView.getBtAccEdit());
		EContactEditButtonClick(settingsView.getBtEContEdit());
		logOutButtonClick(settingsView.getBtLogOut());

		loadContacts(settingsView.geteContact1Menu());
		loadContacts(settingsView.geteContact2Menu());
		loadContacts(settingsView.geteContact3Menu());
		
		
	}

	/**
	 * load contatcs on the dropdown menu Emergency contacs
	 */
	public void loadContacts(ComboBox<Contact> cb) {
		cb.setItems(settingsModel.getDbConnector().getLoginAccount().getContacts());
		cb.setItemCaptionGenerator(Contact::getName);
	}

	/**
	 * initialize settings text fields with LoginAccount information
	 */
	public void initTextFields(SettingsViewImpl View) {

		View.getEmailTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getEmail());
		View.getPasswordTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getPassword());
		View.getFirstNameTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getFirstName());
		View.getLastNameTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getLastName());
		View.getStreetTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getStreet());
		View.getCityTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getCity());
		View.getZipCodeTextField().setValue(settingsModel.getDbConnector().getLoginAccount().getZipCode());

	}

	@Override
	// public void AccEditButtonClick(Button btn){
	// // tentar mudar esse if ara algo diferente de uma string
	// if (settingsView.getBtAccEdit().getCaption().equals("Edit")) {
	// settingsView.getBtAccEdit().setCaption("Save");
	//
	// } else {
	// settingsView.getBtAccEdit().setCaption("Edit");
	// // disable fields
	// settingsView.setUserInfofieldsState(false);

	// // }
	// }

	/**
	 * Add function to the Button Account Edit
	 * 
	 * @param btn
	 */
	public void AccEditButtonClick(Button btn) {
		btn.addClickListener(e -> {

			if (btn.getCaption().equals("Edit")) {
				btn.setCaption("Save");
				settingsView.setUserInfofieldsState(true);
				

			} else {
				btn.setCaption("Edit");
				settingsView.setUserInfofieldsState(false);
		
			
				
				
				
				// save changes to the databank

				// settingsModel.getDbConnector().getLoginAccount().setEmail(getEmailTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setFirstName(getFirstNAmeTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setLastName(getLastNameTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setEmail(getEmailTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setStreet(getStreetTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setZipCode(getZipCodeTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setCity(getCityTextField().getValue());
				// settingsModel.getDbConnector().getLoginAccount().setPassword(getPasswordTextField().getValue());
				//
				// SAVE THE CHOSEN VALUES
				// settingsModel.getDbConnector().getLoginAccount().eContact1 =
				// settingsView.geteContact1Menu().getValue();
				// settingsModel.getDbConnector().getLoginAccount().eContact2 =
				// settingsView.geteContact2Menu().getValue();
				// settingsModel.getDbConnector().getLoginAccount().eContact3 =
				// settingsView.geteContact3Menu().getValue();

				// settingsModel.getDbConnector().REFRESH

			}
		});
	}

	/**
	 * Add function to the Button Econtacts Edit
	 * 
	 * @param btn
	 */
	@Override
	public void EContactEditButtonClick(Button btn) {
		btn.addClickListener(e -> {
			if (btn.getCaption().equals("Edit")) {
				btn.setCaption("Save");
				settingsView.setContactMenusState(true);

			} else {
				btn.setCaption("Edit");
				settingsView.setContactMenusState(false);

			}

		});
	}

	/**
	 * Add function to the Button Logout
	 * 
	 * @param btn
	 */
	public void logOutButtonClick(Button btn) {
		btn.addClickListener(e -> {
			ui.getSession().setAttribute("user", null);
			navigator.navigateTo("LoginView");
			
		});

	}
	
	
	

}
