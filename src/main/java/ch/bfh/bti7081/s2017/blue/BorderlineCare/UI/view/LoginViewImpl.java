package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.LoginViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;

/**
 * @author cpolo
 *
 */
public class LoginViewImpl extends CustomComponent implements View {
	//Name of the View
	public static final String NAME = "LoginView";
	
	// Components
	private List<LoginViewButtonClickListener> listeners = new ArrayList<LoginViewButtonClickListener>();
	private Button buttonLogin;
	private Button buttonSignUp;
	private TextField loginName;
	private TextField loginPassword;
	private Label loginLabel;

	public LoginViewImpl() {

		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
        
		// Textfields
		loginName = new TextField();
		loginName.setCaption("Username");

		loginPassword = new TextField();
		loginPassword.setCaption("Password");
		
		//Labels
		loginLabel = new Label();
		loginLabel.setCaption("not logged in");

		// Buttons
		buttonLogin = new Button("Login");
		buttonLogin.addClickListener(e ->{
			for(LoginViewButtonClickListener listener : listeners){
				listener.loginButtonClick();
			}
		});

		buttonSignUp = new Button("Sign Up");
		buttonSignUp.addClickListener(e ->{
			for(LoginViewButtonClickListener listener : listeners){
				listener.signUpButtonClick();
			}
		});

		// Add all components
		vLayout.addComponent(loginName);
		vLayout.addComponent(loginPassword);
		vLayout.addComponent(buttonLogin);
		vLayout.addComponent(buttonSignUp);
		vLayout.addComponent(loginLabel);
		vLayout.setComponentAlignment(buttonLogin, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(buttonSignUp, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginName, Alignment.MIDDLE_CENTER);
		vLayout.setComponentAlignment(loginPassword, Alignment.MIDDLE_CENTER);
		loginName.focus();

	}

	public void addListener(LoginViewButtonClickListener loginClickListener) {
		listeners.add(loginClickListener);
	}

	public String getLoginName() {
		return loginName.getValue();
	}

	public String getLoginPassword() {
		return loginPassword.getValue();
	}

	public void setLoginLabel(String loginLabel) {
		this.loginLabel.setCaption(loginLabel);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
