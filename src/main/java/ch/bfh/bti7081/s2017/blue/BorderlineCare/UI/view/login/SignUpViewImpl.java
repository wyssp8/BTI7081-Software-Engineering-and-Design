package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;

public class SignUpViewImpl extends CustomComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1426865475605876943L;

	// View Name
	public static final String NAME = "SignUpView";

	// Components
	private List<SignUpViewButtonClickListener> listeners = new ArrayList<SignUpViewButtonClickListener>();

	private Button buttonCreateAcc;
	private Button buttonCancel;
	private TextField firstName;
	private TextField lastName;
	private TextField street;
	private TextField zipCode;
	private TextField city;
	private TextField tel;
	private TextField email;
	private PasswordField password;
	private PasswordField passwordConfirmation;
	Binder<LoginAccount> binder = new Binder<>();
	
	public SignUpViewImpl() {

		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
		
		Panel panel = new Panel("Sign Up");
		panel.setSizeUndefined();
		panel.addStyleName("signUpPanel");
		vLayout.addComponent(panel);
		
		FormLayout content = new FormLayout();
		content.addStyleName("signUpPanel");
		
		HorizontalLayout hLayout = new HorizontalLayout();
		

		// Create Account button
		buttonCreateAcc = new Button("Create");
		buttonCreateAcc.setEnabled(false);
		buttonCreateAcc.addClickListener(e -> {
			for (SignUpViewButtonClickListener listener : listeners) {
				listener.createAccButtonClick();
			}
		});

		// Cancel button
		buttonCancel = new Button("Cancel");
		buttonCancel.addClickListener(e -> {
			for (SignUpViewButtonClickListener listener : listeners) {
				listener.cancelButtonClick();
			}
		});

		// Textfields
		firstName = new TextField();
		firstName.setCaption("First Name");
		binder.forField(firstName)
				.withValidator(new StringLengthValidator("Must be between 2 and 20 characters long", 2, 20))
				.bind(LoginAccount::getFirstName, LoginAccount::setFirstName);

		lastName = new TextField();
		lastName.setCaption("Last Name");
		binder.forField(lastName)
				.withValidator(new StringLengthValidator("Must be between 2 and 20 characters long", 2, 20))
				.bind(LoginAccount::getLastName, LoginAccount::setLastName);

		street = new TextField();
		street.setCaption("Street");
		binder.forField(street)
				.withValidator(new StringLengthValidator("Must be between 2 and 20 characters long", 2, 20))
				.bind(LoginAccount::getStreet, LoginAccount::setStreet);

		zipCode = new TextField();
		zipCode.setCaption("Zip Code");
		binder.forField(zipCode)
				.withValidator(new StringLengthValidator("Must be between 2 and 20 characters long", 2, 20))
				.bind(LoginAccount::getZipCode, LoginAccount::setZipCode);

		city = new TextField();
		city.setCaption("City");
		binder.forField(city)
				.withValidator(new StringLengthValidator("Must be between 2 and 20 characters long", 2, 20))
				.bind(LoginAccount::getCity, LoginAccount::setCity);

		email = new TextField();
		email.setCaption("Email Address");
		binder.forField(email).withValidator(new EmailValidator("This is not a valid email address"))
				.bind(LoginAccount::getEmail, LoginAccount::setEmail);

		password = new PasswordField();
		password.setCaption("Password");
		binder.forField(password).withValidator(str -> str.length() >= 7, "Must be at least 7 chars")
				.bind(LoginAccount::getPassword, LoginAccount::setPassword);

		passwordConfirmation = new PasswordField();
		passwordConfirmation.setCaption("Confirm your password");
		binder.forField(passwordConfirmation)
				.withValidator(str -> str.equals(password.getValue()), "Passwords don't match")
				.bind(LoginAccount::getLastName, LoginAccount::setLastName);


		// add all components
		content.addComponent(firstName);
		content.addComponent(lastName);
		content.addComponent(street);
		content.addComponent(zipCode);
		content.addComponent(city);
		content.addComponent(email);
		content.addComponent(password);
		content.addComponent(passwordConfirmation);
		content.addComponent(hLayout);		
		hLayout.addComponent(buttonCreateAcc);
		hLayout.addComponent(buttonCancel);
		
		content.setSizeUndefined(); // Shrink to fit
		content.setMargin(true);
		panel.setContent(content);

		//Check if all fields are valid everytime one field gets changed
		binder.addStatusChangeListener(event -> {
			if (binder.isValid()) {
				buttonCreateAcc.setEnabled(true);
			} else {
				buttonCreateAcc.setEnabled(false);
			}
		});
	}
	
	public void addListener(SignUpViewButtonClickListener signUpClickListener) {
		listeners.add(signUpClickListener);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		firstName.focus();

	}

	public String getFirstName() {
		return firstName.getValue();
	}

	public String getLastName() {
		return lastName.getValue();
	}

	public String getStreet() {
		return street.getValue();
	}

	public String getZipCode() {
		return zipCode.getValue();
	}

	public String getCity() {
		return city.getValue();
	}

	public String getTel() {
		return tel.getValue();
	}

	public String getEmail() {
		return email.getValue();
	}

	public String getPassword() {
		return password.getValue();
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation.getValue();
	}
	

}
