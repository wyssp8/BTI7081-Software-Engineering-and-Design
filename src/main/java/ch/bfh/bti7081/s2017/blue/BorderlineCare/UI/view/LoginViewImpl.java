package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;

public class LoginViewImpl extends CustomComponent implements ClickListener{
	
	private List<LoginViewButtonClickListener> listeners = new ArrayList<LoginViewButtonClickListener>();
	private Button buttonLogin;
	private Button buttonSignUp;
	private TextField loginName;
	public TextField loginPassword;
	
	
	public LoginViewImpl() {
		
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
		
		
		
		//Textfields
		loginName = new TextField();
		loginName.setCaption("Username");
		
		loginPassword = new TextField();
		loginPassword.setCaption("Password");

		
		//Buttons
		buttonLogin = new Button("Login");
		buttonLogin.addClickListener(this);
		
		buttonSignUp = new Button("Sign Up");
		buttonSignUp.addClickListener(this);
		
		
		//Add all components
		vLayout.addComponent(loginName);
		vLayout.addComponent(loginPassword);
		vLayout.addComponent(buttonLogin);
		vLayout.addComponent(buttonSignUp);
		vLayout.setComponentAlignment(buttonLogin, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(buttonSignUp, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginName, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginPassword, Alignment.MIDDLE_CENTER);
		loginName.focus();

	}

	
	
	
	
	public void addListener(LoginViewButtonClickListener clickListener) {
		listeners.add(clickListener);
	}

	@Override
	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for(LoginViewButtonClickListener listener : listeners){
			listener.loginButtonClick();
			if(event.getSource().equals("Login")){
				listener.loginButtonClick();
			}		
//			switch (event.getButton().equals("Login")){
//			case 1: listener.loginButtonClick();
//			break;
//			
//			}
		}
	}

}
