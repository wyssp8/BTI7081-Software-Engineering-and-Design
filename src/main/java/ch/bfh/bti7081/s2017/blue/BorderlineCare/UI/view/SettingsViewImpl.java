package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SettingsClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.SettingsView;

/**
 * @author André completar aqui a descrição dessa classes
 */

public class SettingsViewImpl extends CustomComponent implements SettingsView {

	private static final long serialVersionUID = 1L;

	private Accordion accordion = new Accordion();

	private List<SettingsClickListener> listeners = new ArrayList<>();

	private Contact eContact1;
	private Contact eContact2;
	private Contact eContact3;

	private TextField emailTextField;
	private TextField firstNameTextField;
	private TextField lastNameTextField;
	private TextField streetTextField;
	private TextField zipCodeTextField;
	private TextField cityTextField;

	private PasswordField passwordTextField;

	private Button btEContEdit;
	private Button btLogOut;
	private Button btAccEdit;

	private GridLayout accountSettings;
	private GridLayout eContactSettings;

	private ComboBox<Contact> eContact1Menu;
	private ComboBox<Contact> eContact2Menu;
	private ComboBox<Contact> eContact3Menu;

	public SettingsViewImpl() {

		emailTextField = new TextField();
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();
		streetTextField = new TextField();
		zipCodeTextField = new TextField();
		cityTextField = new TextField();

		passwordTextField = new PasswordField();

		btEContEdit = new Button("Edit");

		btAccEdit = new Button("Edit");

		btLogOut = new Button("LogOut");

		eContact1Menu = new ComboBox<>();
		eContact2Menu = new ComboBox<>();
		eContact3Menu = new ComboBox<>();

		Layout tab1 = new HorizontalLayout();
		Layout loginSettingsFields = new VerticalLayout();
		Layout loginSettingsLabels = new VerticalLayout();
		Layout tab2 = new HorizontalLayout();
		Layout eContactsField = new VerticalLayout();
		Layout eContactsLabels = new VerticalLayout();

		accountSettings = new GridLayout(2, 7);
		accountSettings.addStyleName("Login Settings");
		accountSettings.setSpacing(true);
		addAccountSettings();

		eContactSettings = new GridLayout(2, 3);
		eContactSettings.addStyleName("Emergency Contatcs");
		eContactSettings.setSpacing(true);
		addContactSettings();

		tab1.addComponents(loginSettingsFields, loginSettingsLabels);
		tab2.addComponents(eContactsField, eContactsLabels);

		accordion.addTab(accountSettings, "Account Settings");
		accordion.addTab(eContactSettings, "Emergency Contacts");

		btAccEdit.addClickListener(e -> {

			for (SettingsClickListener listener : listeners) {
				listener.AccEditButtonClick(btAccEdit);
			}
		});

		btEContEdit.addClickListener(e -> {
			for (SettingsClickListener listener : listeners) {
				listener.EContactEditButtonClick(btEContEdit);
			}
		});

		btLogOut.addClickListener(e -> {
			for (SettingsClickListener listener : listeners) {
				listener.logOutButtonClick();
			}
		});

		setUserInfoFieldsState(false);
		setContactMenusState(false);

		setCompositionRoot(accordion);
	}




	public List<SettingsClickListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<SettingsClickListener> listeners) {
		this.listeners = listeners;
	}

	public Contact geteContact1() {
		return eContact1;
	}

	public void seteContact1(Contact eContact1) {
		this.eContact1 = eContact1;
	}

	public Contact geteContact2() {
		return eContact2;
	}

	public void seteContact2(Contact eContact2) {
		this.eContact2 = eContact2;
	}

	public Contact geteContact3() {
		return eContact3;
	}

	public void seteContact3(Contact eContact3) {
		this.eContact3 = eContact3;
	}

	public TextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(TextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public TextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(TextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public TextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(TextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public TextField getStreetTextField() {
		return streetTextField;
	}

	public void setStreetTextField(TextField streetTextField) {
		this.streetTextField = streetTextField;
	}

	public TextField getZipCodeTextField() {
		return zipCodeTextField;
	}

	public void setZipCodeTextField(TextField zipCodeTextField) {
		this.zipCodeTextField = zipCodeTextField;
	}

	public TextField getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(TextField cityTextField) {
		this.cityTextField = cityTextField;
	}

	public PasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(PasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public Button getBtEContEdit() {
		return btEContEdit;
	}

	public void setBtEContEdit(Button btEContEdit) {
		this.btEContEdit = btEContEdit;
	}

	public Button getBtLogOut() {
		return btLogOut;
	}

	public void setBtLogOut(Button btLogOut) {
		this.btLogOut = btLogOut;
	}

	public Button getBtAccEdit() {
		return btAccEdit;
	}

	public void setBtAccEdit(Button btAccEdit) {
		this.btAccEdit = btAccEdit;
	}

	public GridLayout geteContactSettings() {
		return eContactSettings;
	}

	public void seteContactSettings(GridLayout eContactSettings) {
		this.eContactSettings = eContactSettings;
	}

	public ComboBox<Contact> geteContact1Menu() {
		return eContact1Menu;
	}

	public void seteContact1Menu(ComboBox<Contact> eContact1Menu) {
		this.eContact1Menu = eContact1Menu;
	}

	/**
	 * Enable and disable edition ContactMenu
	 * 
	 * @param b
	 */
	public void setContactMenusState(boolean b) {
		eContact1Menu.setEnabled(b);
		eContact2Menu.setEnabled(b);
		eContact3Menu.setEnabled(b);
	}

	/**
	 * Enabel and disable user information TextFields
	 * 
	 * @param b
	 */
	public void setUserInfoFieldsState(boolean b) {

		getEmailTextField().setEnabled(b);
		getFirstNameTextField().setEnabled(b);
		getLastNameTextField().setEnabled(b);
		getStreetTextField().setEnabled(b);
		getZipCodeTextField().setEnabled(b);
		getCityTextField().setEnabled(b);
		getPasswordTextField().setEnabled(b);
	}

	@Override
	public void addClickListener(SettingsClickListener clickListener) {
		listeners.add(clickListener);
	}

	/**
	 * Add the labels and textfieds to the layout
	 */
	public void addAccountSettings() {
		accountSettings.addComponents(new Label("email"), emailTextField, new Label("password"), passwordTextField,
				new Label("First name"), firstNameTextField, new Label("Last name"), lastNameTextField,
				new Label("Street"), streetTextField, new Label("Zipcode"), zipCodeTextField, new Label("City"),
				cityTextField, btAccEdit, btLogOut);
	}

	/**
	 * Add the contact components to the layout
	 */
	public void addContactSettings() {
		eContactSettings.addComponents(eContact1Menu, new Label("Emergency Contact"), btEContEdit);
	}

}
