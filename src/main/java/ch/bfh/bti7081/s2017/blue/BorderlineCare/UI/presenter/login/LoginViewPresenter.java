package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.login;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.LoginViewImpl;

/**
 * @author cpolo
 *
 */
public class LoginViewPresenter extends CustomComponent implements LoginViewButtonClickListener, View {

	private LoginViewModel loginViewModel;
	private LoginViewImpl loginViewImpl;
	private Navigator navigator;
	private boolean passwordMatched;
	private boolean userMatched;

	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl, Navigator navigator) {
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		this.navigator = navigator;
		loginViewImpl.addListener(this);
	}

	public void loginButtonClick() {
		if (validateLogin()) {
			loginViewImpl.setLoginLabel("logged in");
			navigator.navigateTo("HomeView");
		} else
			Notification.show("Failed login", "you suck", Notification.Type.WARNING_MESSAGE);
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
	public boolean validateLogin() {

		for (LoginAccount loginAccount : loginViewModel.getLoginAccounts()) {

			try {
				passwordMatched = validatePassword(loginViewImpl.getLoginPassword(), loginAccount.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
			System.out.println(passwordMatched);

			userMatched = validateUsername(loginAccount);
			if (userMatched && passwordMatched) {
				return true;

				//getSession().setAttribute("user",loginAccount.getFirstName());
			}
		}
		return false;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	// validate username
	private boolean validateUsername(LoginAccount loginAccount) {
		if (loginViewImpl.getLoginName().equals(loginAccount.getEmail())) {
			return true;
		}
		return false;
	}

	// validate secure password for login
	private static boolean validatePassword(String originalPassword, String storedPassword)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);

		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] testHash = skf.generateSecret(spec).getEncoded();

		int diff = hash.length ^ testHash.length;
		for (int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}
		return diff == 0;
	}

	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
