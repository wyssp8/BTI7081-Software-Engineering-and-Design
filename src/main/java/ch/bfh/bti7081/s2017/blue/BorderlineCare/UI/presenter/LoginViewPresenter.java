package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.LoginViewImpl;

public class LoginViewPresenter implements LoginViewButtonClickListener {
	
	
	// TODO Auto-generated method stub
	LoginViewModel loginViewModel;
	LoginViewImpl loginViewImpl;
	LoginAccount loginAccount;


	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl, LoginAccount loginAccount){
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		this.loginAccount = loginAccount;
		loginViewImpl.addListener(this);
		//loginViewImpl.setName("Clear Textarea");
	}

//	@Override
//	public void buttonClick() {
//		
//		
//	}

	public void loginButtonClick() {
		// TODO Auto-generated method stub
		if(loginViewImpl.getLoginName().equals(loginAccount.getLoginName())){
			loginViewImpl.setLoginLabel("logged in");
		}

		
		
	}

	@Override
	public void signUpButtonClick() {
		//loginViewImpl.loginPassword.setValue("Signed Up");
	}
}
