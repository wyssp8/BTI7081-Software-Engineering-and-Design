package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface LoginViewButtonClickListener {
	public void loginButtonClick();
	public void signUpButtonClick();
	public void bypassButtonClick();
	public boolean validateLogin();
}
