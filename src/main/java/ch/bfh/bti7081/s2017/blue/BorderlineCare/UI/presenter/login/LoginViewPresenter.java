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
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.DiaryViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.EmergencyViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ExerciseDashViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ExercisesViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.MainViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.SettingsViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.LoginViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ContactViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ExerciseViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.NavigationViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.LoginViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.DiaryDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.ExerciseDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

/**
 * 
 * @author cpolo
 *
 */
public class LoginViewPresenter extends CustomComponent implements LoginViewButtonClickListener, View {

	private static final long serialVersionUID = 1082791095382801193L;
	
	private LoginViewModel loginViewModel;
	private LoginViewImpl loginViewImpl;
	private Navigator navigator;
	private boolean passwordMatched;
	private boolean userMatched;
	private String username;
	private UI ui = UI.getCurrent();

	public LoginViewPresenter(LoginViewModel loginViewModel, LoginViewImpl loginViewImpl, Navigator navigator) {
		this.loginViewModel = loginViewModel;
		this.loginViewImpl = loginViewImpl;
		this.navigator = navigator;
		loginViewImpl.addListener(this);
	}

	public void loginButtonClick() {
		if (validateLogin()) {
			
			//Store current user
			username = loginViewModel.getLoginAccount().getEmail();
			ui.getSession().setAttribute("user", username);
			initializeViewsAfterLogin();
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
		DBConnector.getDBConnector().setAccountEmail("wyssp8@gmail.com");
		username = "bypass";
		ui.getSession().setAttribute("user", username);
		initializeViewsAfterLogin();
		navigator.navigateTo("HomeView");
	}

	@Override
	public boolean validateLogin() {
		try{
			DBConnector.getDBConnector().setAccountEmail(loginViewImpl.getLoginName());
			LoginAccount loginAccount = DBConnector.getDBConnector().getLoginAccount();
			loginViewModel.setLoginAccount(loginAccount);
			
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
				loginViewModel.setLoginAccountEmail(loginViewImpl.getLoginName());
				DBConnector.getDBConnector().setAccountEmail(loginViewImpl.getLoginName());
				return true;
			}
		}catch(NullPointerException e){
			Notification.show("Username or password wrong", "try again", Notification.Type.WARNING_MESSAGE);
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

	// validate secure password for login -->model
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
	
	public void initializeViewsAfterLogin(){
		//Main View
    	ExerciseDashViewImpl exerciseDashViewImpl = new ExerciseDashViewImpl();
    	DiaryDashViewImpl diaryDashViewImpl = new DiaryDashViewImpl();
        EmergencyViewImpl emergencyViewImpl = new EmergencyViewImpl();
    	EmergencyViewModel emergencyViewModel = new EmergencyViewModel();
    	new EmergencyViewPresenter(emergencyViewImpl,emergencyViewModel);
    	MainViewImpl mainView = new MainViewImpl(exerciseDashViewImpl,diaryDashViewImpl,emergencyViewImpl);
    	MainViewModel model = new MainViewModel();
    	new MainViewPresenter(model, mainView);
    	

    	//Contact View
    	ContactViewImpl contactViewImpl = new ContactViewImpl();
    	ContactModel contactModel = new ContactModel();
    	new ContactViewPresenter(contactModel, contactViewImpl);
    	
    	
    	//Diary View
    	DiaryViewModel diaryViewModel = new DiaryViewModel();
    	DiaryViewImpl diaryViewImpl = new DiaryViewImpl();
    	new DiaryViewPresenter(diaryViewModel, diaryViewImpl);
    	

    	//Settings View
    	SettingsViewImpl settingsViewImpl = new SettingsViewImpl();   	
    	SettingsViewModel settingsModel = new SettingsViewModel();
    	
    	new SettingsViewPresenter (settingsModel , settingsViewImpl,  contactModel, navigator);
    	

    	//Exercises View
    	ExerciseViewImpl exerciseViewImpl = new ExerciseViewImpl();
    	ExercisesViewModel exercisesViewModel = new ExercisesViewModel();
    	new ExercisesViewPresenter(exerciseViewImpl, exercisesViewModel);

    	NavigationViewImpl view = new NavigationViewImpl(mainView,contactViewImpl,diaryViewImpl,exerciseViewImpl,settingsViewImpl);

     
    	new ExerciseDashViewPresenter(exerciseDashViewImpl, exercisesViewModel, view);
    	
    	navigator.addView("HomeView", view);
        
	}
	
}
