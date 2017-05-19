package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.SignUpViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SignUpViewImpl;

public class SignUpViewPresenter extends CustomComponent implements SignUpViewButtonClickListener,View {

	private SignUpViewModel signUpViewModel;
	private SignUpViewImpl signUpViewImpl;
	private LoginAccount loginAccount;
	private LoginViewModel loginViewModel;
	private List<LoginAccount> loginAccounts;
	private Navigator navigator;
	
	public SignUpViewPresenter(SignUpViewModel signUpViewModel, SignUpViewImpl signUpViewImpl, Navigator navigator) {
		this.signUpViewModel = signUpViewModel;
		this.signUpViewImpl = signUpViewImpl;
		this.navigator = navigator;
		//signUpViewImpl.addListener(this);
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccButtonClick() {
		//First Name						
		//Last Name	
		//Street
		//Zip Code
		//City
		//Email
		//Password
		//Password Confirmation
		navigator.navigateTo("LoginView");
		signUpViewModel.getLoginAccount().add(
		new LoginAccount(
				signUpViewImpl.getFirstName(),
				signUpViewImpl.getLastName(),
				signUpViewImpl.getStreet(),
				signUpViewImpl.getZipCode(),
				signUpViewImpl.getCity(),
				signUpViewImpl.getEmail(),
				signUpViewImpl.getPassword(),
				null));		
	}

	@Override
	public void cancelButtonClick() {
		navigator.navigateTo("LoginView");
		
	}

}
