package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.LoginViewImpl;

public class LoginViewPresenter implements ButtonClickListener {
	
	
	// TODO Auto-generated method stub
	LoginViewModel loginViewModel;
	LoginViewImpl loginViewImpl;


	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl){
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		loginViewImpl.addListener(this);
		//loginViewImpl.setName("Clear Textarea");
	}

	@Override
	public void buttonClick() {
		
	}
}
