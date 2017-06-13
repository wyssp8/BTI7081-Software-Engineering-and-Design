package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;

/**
 * @author cpolo
 *
 */
public class LoginViewImpl extends CustomComponent implements View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -993511150384312326L;

	// Name of the View
	public static final String NAME = "LoginView";

	// Components
	private List<LoginViewButtonClickListener> listeners = new ArrayList<LoginViewButtonClickListener>();
	private Button buttonLogin;
	private Button buttonSignUp;
	private TextField loginName;
	private PasswordField loginPassword;

	public LoginViewImpl() {


		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
		
		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		panel.addStyleName("loginPanel");
		vLayout.addComponent(panel);
		
		FormLayout content = new FormLayout();
		content.addStyleName("loginPanel");
		
		HorizontalLayout hLayout = new HorizontalLayout();
		
		

		// Textfields
		loginName = new TextField();
		loginName.setCaption("Username");

		loginPassword = new PasswordField();
		loginPassword.setCaption("Password");

		// Labels
		loginPassword = new PasswordField();
		loginPassword.setCaption("Password");	
		
		// Button Login
		buttonLogin = new Button("Login");
		buttonLogin.addClickListener(e -> {
			for (LoginViewButtonClickListener listener : listeners) {
				listener.loginButtonClick();
			}
		});

		// Button SignUp
		buttonSignUp = new Button("Sign Up");
		buttonSignUp.addClickListener(e -> {
			for (LoginViewButtonClickListener listener : listeners) {
				listener.signUpButtonClick();
			}
		});
		

		// Add all components
		content.addComponent(loginName);
		content.addComponent(loginPassword);
		content.addComponent(hLayout);
		hLayout.addComponent(buttonLogin);
		hLayout.addComponent(buttonSignUp);
		
		content.setSizeUndefined(); // Shrink to fit
		content.setMargin(true);
		panel.setContent(content);
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

	@Override
	public void enter(ViewChangeEvent event) {
		loginName.focus();

	}
}
