package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.io.ObjectInputStream.GetField;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SignUpViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SignUpViewImpl;

public class SignUpViewPresenter extends CustomComponent implements SignUpViewButtonClickListener,View {

	private SignUpViewModel signUpViewModel;
	private SignUpViewImpl signUpViewImpl;
	private LoginAccount loginAccount;
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
		new LoginAccount(null,null,null,null,null,null,null,null);							
		
	}

	@Override
	public void cancelButtonClick() {
		// TODO Auto-generated method stub
		
	}

}
