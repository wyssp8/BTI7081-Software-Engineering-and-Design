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

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

/**
 * @author André
 *
 */

public class SettingsViewImpl extends CustomComponent {

	private static final long serialVersionUID = 1L;

	
	private VerticalLayout layout = new VerticalLayout();
	Accordion accordion = new Accordion();

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
	// private Button btESaveChanges = new Button("Change PAssword");
	private Button btLogOut = new Button("LogOut");
	private Button btEdit = new Button("Edit");

	private ComboBox<Contact> eContact1Menu = new ComboBox<>();
	private ComboBox<Contact> eContact2Menu = new ComboBox<>();
	private ComboBox<Contact> eContact3Menu = new ComboBox<>();

	/**
	 * Will receive a dbConnector and save the chosen eContacst to the account
	 * on the databank
	 * 
	 * @param dbConnector
	 */
	public void saveEcontactsOnDB(DBConnector dbConnector) {
		// dbConnector.getLoginAccount().setEContact1(eContact1);
		// dbConnector.getLoginAccount().setEContact2(eContact2);
		// dbConnector.getLoginAccount().setEContact3(eContact3);

	}

	public TextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(TextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public Button getBtEContSave() {
		return btEContSave;
	}

	public void setBtEContSave(Button btEContSave) {
		this.btEContSave = btEContSave;
	}

	public Button getBtLogOut() {
		return btLogOut;
	}

	public void setBtLogOut(Button btLogOut) {
		this.btLogOut = btLogOut;
	}

	public Button getBtEdit() {
		return btEdit;
	}

	public void setBtEdit(Button btEdit) {
		this.btEdit = btEdit;
	}

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

	public TextField getLoginTextField() {
		return emailTextField;
	}

	public void setLoginTextField(TextField login) {
		this.emailTextField = login;
	}

	public PasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(PasswordField password) {
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
	 * save the emergency contacts to the database
	 */

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

		loginSettings.addComponents(new Label("email"), emailTextField, new Label("password"), passwordTextField,
				new Label("First name"), firstNameTextField, new Label("Last name"), lastNameTextField,
				new Label("Street"), streetTextField, new Label("Zipcode"), zipCodeTextField, new Label("City"),
				cityTextField, btEdit, btLogOut);

		loginSettings.setSpacing(true);

		GridLayout eContactSettings = new GridLayout(2, 3);
		eContactSettings.addStyleName("Emergency Contatcs");
		eContactSettings.addComponents(eContact1Menu, new Label("Emergency Contact 1"), eContact2Menu,
				new Label("Emergency Contact 2"), eContact3Menu, new Label("Emergency Contact 3"), btEContSave);

		eContactSettings.setSpacing(true);

		tab1.addComponents(loginSettingsFields, loginSettingsLabels);
		tab2.addComponents(eContactsField, eContactsLabels);

		accordion.addTab(loginSettings, "Account Settings");
		accordion.addTab(eContactSettings, "Emergency Contacts");

		setCompositionRoot(accordion);
		
		/** go back to login screen
		 * 
		 */
		btLogOut.addClickListener(e -> {
			navigator.navigateTo("HomeView");
		});

	}

}
