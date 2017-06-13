package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.login;



import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.Util;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.SignUpViewImpl;

public class SignUpViewPresenter extends CustomComponent implements SignUpViewButtonClickListener,View {


	private static final long serialVersionUID = 2288314058697414321L;
	private SignUpViewImpl signUpViewImpl;
	private LoginViewModel loginViewModel;
	
	private Navigator navigator;
	private String generatedSecuredPasswordHash;
	private Util util = new Util();
	
	public SignUpViewPresenter(SignUpViewImpl signUpViewImpl, Navigator navigator,LoginViewModel loginViewModel) {
		this.signUpViewImpl = signUpViewImpl;
		this.loginViewModel = loginViewModel;
		this.navigator = navigator;
		signUpViewImpl.addListener(this);
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		
	}

	@Override
	public void createAccButtonClick() {
		try {
			generatedSecuredPasswordHash = util.generateStorngPasswordHash(signUpViewImpl.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
        System.out.println(generatedSecuredPasswordHash);
		
        LoginAccount loginAccount = new LoginAccount(
				signUpViewImpl.getFirstName(),
				signUpViewImpl.getLastName(),
				signUpViewImpl.getStreet(),
				signUpViewImpl.getZipCode(),
				signUpViewImpl.getCity(),
				signUpViewImpl.getEmail(),
				generatedSecuredPasswordHash);
        
		//loginViewModel.setLoginAccount(loginAccount);
		try {
			loginViewModel.addNewLoginAccount(loginAccount);
			
		} catch (Exception e) {
			System.err.println("EMail-Adresse bereits registriert");
		}
		navigator.navigateTo("LoginView");
	}

	@Override
	public void cancelButtonClick() {
		navigator.navigateTo("LoginView");	
	}    
}
