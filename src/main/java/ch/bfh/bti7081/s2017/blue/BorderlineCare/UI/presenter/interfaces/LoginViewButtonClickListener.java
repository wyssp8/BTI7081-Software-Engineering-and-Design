package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces;

/**
 * Interface for the LoginView for the login and signup button
 * and to validate the entered login credentials
 * @author cpolo
 *
 */
public interface LoginViewButtonClickListener {
	public void loginButtonClick();
	public void signUpButtonClick();
	public void bypassButtonClick();
	public boolean validateLogin();
}
