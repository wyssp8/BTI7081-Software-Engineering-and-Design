package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;

public class SignUpViewImpl extends CustomComponent implements View {
	
	//View Name
	public static final String NAME = "SignUpView";
	
	//Components
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
	
	public SignUpViewImpl(){
		
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
		
		buttonCreateAcc = new Button("Create");
		buttonCreateAcc.addClickListener(e ->{
			for(SignUpViewButtonClickListener listener : listeners){
				listener.createAccButtonClick();
			}
		});
		buttonCancel = new Button("Cancel");
		buttonCancel.addClickListener(e ->{
			for(SignUpViewButtonClickListener listener : listeners){
				listener.cancelButtonClick();
			}
		});
		
		// Textfields
		firstName = new TextField();
		firstName.setCaption("First Name");
		//firstName.setWidth("30%");
		
		lastName = new TextField();
		lastName.setCaption("Last Name");
		//lastName.setWidth("30%");
		
		street = new TextField();
		street.setCaption("Street");
		//street.setWidth("30%");
		
		zipCode = new TextField();
		zipCode.setCaption("Zip Code");
		//zipCode.setWidth("30%");
		
		city = new TextField();
		city.setCaption("City");
		//city.setWidth("30%");
		
		email = new TextField();
		email.setCaption("Email Address");
		//email.setWidth("30%");
		
		password = new PasswordField();
		password.setCaption("Password");
		//password.setWidth("30%");
		
		passwordConfirmation = new PasswordField();
		passwordConfirmation.setCaption("Confirm your password");
		//passwordConfirmation.setWidth("30%");
		
		
		//add all components
		vLayout.addComponent(firstName);
		vLayout.addComponent(lastName);
		vLayout.addComponent(street);
		vLayout.addComponent(zipCode);
		vLayout.addComponent(city);
		vLayout.addComponent(email);
		vLayout.addComponent(password);
		vLayout.addComponent(passwordConfirmation);
		vLayout.setComponentAlignment(firstName, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(lastName, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(street, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(zipCode, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(city, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(email, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(passwordConfirmation, Alignment.MIDDLE_CENTER);
		vLayout.addComponent(buttonCreateAcc);
		vLayout.addComponent(buttonCancel);
		

		
		
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
