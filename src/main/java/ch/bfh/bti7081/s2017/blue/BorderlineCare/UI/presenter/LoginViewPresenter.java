package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.LoginViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.NavigationViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SignUpViewImpl;

/**
 * @author cpolo
 *
 */
public class LoginViewPresenter extends CustomComponent implements LoginViewButtonClickListener, View {
	
	private LoginViewModel loginViewModel;
	private LoginViewImpl loginViewImpl;
	//private LoginAccount loginAccount;
	private Navigator navigator;


	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl, Navigator navigator){
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		this.navigator = navigator;
		loginViewImpl.addListener(this);
	}

	public void loginButtonClick() {
		if(authenticateLogin()){
			loginViewImpl.setLoginLabel("logged in");
			navigator.navigateTo("HomeView");
		}	
	}

	@Override
	public void signUpButtonClick() {
		loginViewImpl.setLoginLabel("signed up");
		navigator.navigateTo("SignUpView");
	}
	
	@Override
	public void bypassButtonClick() {
		navigator.navigateTo("HomeView");
		
	}

	@Override
	public boolean authenticateLogin() {
		for(LoginAccount loginAccount : loginViewModel.getLoginAccounts())
		if(loginViewImpl.getLoginName().equals(loginAccount.getEmail())&&
				loginViewImpl.getLoginPassword().equals(loginAccount.getPassword())){
			return true;
		}
		return false;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
