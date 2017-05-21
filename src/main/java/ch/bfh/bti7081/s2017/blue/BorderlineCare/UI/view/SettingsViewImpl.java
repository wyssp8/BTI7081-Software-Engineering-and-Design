package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.navigator.Navigator;
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
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;


/**
 * @author André
 *
 */

public class SettingsViewImpl extends CustomComponent {

	private static final long serialVersionUID = 1L;

	private VerticalLayout layout = new VerticalLayout();
	Accordion accordion = new Accordion();

	/**
	 * this contact object will be saved to the Database if the user decide to
	 * changes his contact settings
	 */
	private LoginAccount editedContact;

	/**
	 * the emergency contacts (lather will be used to save emergency contacts on
	 * the database
	 * 
	 */
	private Contact eContact1;
	private Contact eContact2;
	private Contact eContact3;

	private Navigator navigator;

	private Label title = new Label("Settings");
	private TextField emailTextField = new TextField();
	private TextField firstNameTextField = new TextField();
	private TextField lastNameTextField = new TextField();
	private TextField streetTextField = new TextField();
	private TextField zipCodeTextField = new TextField();
	private TextField cityTextField = new TextField();
	private PasswordField passwordTextField = new PasswordField();

	private Button btEContSave = new Button("Save");
	private Button btESaveChanges = new Button("Change PAssword");
	private Button btLogOut = new Button("LogOut");
	private Button btEdit = new Button("Edit");

	private ComboBox<Contact> eContact1Menu = new ComboBox<>();
	private ComboBox<Contact> eContact2Menu = new ComboBox<>();
	private ComboBox<Contact> eContact3Menu = new ComboBox<>();

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TextField loginTextField() {
		return emailTextField;
	}

	public void loginTextField(TextField login) {
		this.emailTextField = login;
	}

	public PasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public void getPasswordTextField(PasswordField password) {
		this.passwordTextField = password;
	}

	public TextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(TextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public TextField getFirstNAmeTextField() {
		return firstNameTextField;
	}

	public void setFirstNAmeTextField(TextField firstNAmeTextField) {
		this.firstNameTextField = firstNAmeTextField;
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

	public void setPasswordTextField(PasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
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

	public ComboBox<Contact> geteContact1Menu() {
		return eContact1Menu;
	}

	public void seteContact1Menu(ComboBox<Contact> eContact1Menu) {
		this.eContact1Menu = eContact1Menu;
	}

	public ComboBox<Contact> geteContact2Menu() {
		return eContact2Menu;
	}

	public void seteContact2Menu(ComboBox<Contact> eContact2Menu) {
		this.eContact2Menu = eContact2Menu;
	}

	public ComboBox<Contact> geteContact3Menu() {
		return eContact3Menu;
	}

	public void seteContact3Menu(ComboBox<Contact> eContact3Menu) {
		this.eContact3Menu = eContact3Menu;
	}

	/**
	 * save the emergency contacts
	 */
	public void saveEContacts() {
		eContact1 = eContact1Menu.getValue();
		eContact2 = eContact2Menu.getValue();
		eContact3 = eContact3Menu.getValue();
	}

	public SettingsViewImpl() {

		/**
		 * set all user infos to be uneditable
		 */
		emailTextField.setEnabled(false);
		firstNameTextField.setEnabled(false);
		lastNameTextField.setEnabled(false);
		streetTextField.setEnabled(false);
		zipCodeTextField.setEnabled(false);
		cityTextField.setEnabled(false);
		passwordTextField.setEnabled(false);

		/**
		 * Create the first tab, specify caption when adding
		 */
		
		Layout tab1 = new HorizontalLayout();
		Layout loginSettingsFields = new VerticalLayout();
		Layout loginSettingsLabels = new VerticalLayout();
		Layout tab2 = new HorizontalLayout();
		Layout eContactsField = new VerticalLayout();
		Layout eContactsLabels = new VerticalLayout();
		
		
		GridLayout loginSettings = new GridLayout(2, 7);
		loginSettings.addStyleName("Login Settings");
		
		loginSettings.addComponents(
				new Label("email"),emailTextField, 
				new Label("password"),passwordTextField,
				new Label("First name"),firstNameTextField,
				new Label("Last name"),lastNameTextField,
				new Label("Street"),streetTextField,
				new Label("Zipcode"),zipCodeTextField,
				new Label("City"),cityTextField,
				btEdit, btLogOut);
		
		loginSettings.setSpacing(true);
		
		GridLayout eContactSettings = new GridLayout(2, 3);
		eContactSettings.addStyleName("Emergency Contatcs");
		eContactSettings.addComponents(eContact1Menu,new Label("Emergency Contact 1"), eContact2Menu,new Label("Emergency Contact 2"), eContact3Menu,new Label("Emergency Contact 3"), btEContSave);
		
		eContactSettings.setSpacing(true);
		
		tab1.addComponents(loginSettingsFields,loginSettingsLabels);
		tab2.addComponents(eContactsField,eContactsLabels);
		
		
		
		accordion.addTab(loginSettings, "Account Settings");
		accordion.addTab(eContactSettings, "Emergency Contacts");

		/**
		 * Ok button to save new emergency contacts
		 */
		btEContSave.addClickListener(e -> {
			saveEContacts();
			eContact1Menu.setEnabled(false);
			eContact2Menu.setEnabled(false);
			eContact3Menu.setEnabled(false);

		});

		btESaveChanges.addClickListener(e -> {

			layout.addComponents(new Label("Contacts saved"));

		});

		btLogOut.addClickListener(e -> {
			navigator.navigateTo("LoginView");
		});

		btEdit.addClickListener(e -> {
			emailTextField.setEnabled(true);
			firstNameTextField.setEnabled(true);
			lastNameTextField.setEnabled(true);
			streetTextField.setEnabled(true);
			zipCodeTextField.setEnabled(true);
			cityTextField.setEnabled(true);
			passwordTextField.setEnabled(true);

			if (btEdit.getCaption().equals("Edit")) {
				btEdit.setCaption("Save");
			} else {
				btEdit.setCaption("Edit");
				emailTextField.setEnabled(false);
				firstNameTextField.setEnabled(false);
				lastNameTextField.setEnabled(false);
				streetTextField.setEnabled(false);
				zipCodeTextField.setEnabled(false);
				cityTextField.setEnabled(false);
				passwordTextField.setEnabled(false);

				editedContact = new LoginAccount(firstNameTextField.getValue(), lastNameTextField.getValue(),
				streetTextField.getValue(), zipCodeTextField.getValue(), cityTextField.getValue(),
				emailTextField.getValue(), passwordTextField.getValue(), passwordTextField.getValue());

			}

		});

		setCompositionRoot(accordion);

	}

}
