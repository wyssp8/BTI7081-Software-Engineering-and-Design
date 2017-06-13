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

import ch.bfh.bti7081.s2017.blue.BorderlineCare.Util;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.DiaryDashViewPresenter;
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
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.SignUpViewImpl;
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
	private Util util = new Util();

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
			navigator.navigateTo("HomeView");
		} 
	}

	@Override
	public void signUpButtonClick() {
		
    	//Initialize SignUp View
    	SignUpViewImpl signUpViewImpl = new SignUpViewImpl();
    	new SignUpViewPresenter(signUpViewImpl, navigator,loginViewModel);
    	navigator.addView("SignUpView", signUpViewImpl);
		navigator.navigateTo("SignUpView");
	}

	@Override
	public void bypassButtonClick() {
		DBConnector.getDBConnector().setAccountEmail("wyssp8@gmail.com");
		username = "wyssp8@gmail.com";
		ui.getSession().setAttribute("user", username);
		initializeViewsAfterLogin();
		navigator.navigateTo("HomeView");
	}


	@Override
	public boolean validateLogin() {
		try{
			loginViewModel.setLoginAccountEmail(loginViewImpl.getLoginName());
			LoginAccount loginAccount = loginViewModel.getLoginAccount();		
			try {
				passwordMatched = util.validatePassword(loginViewImpl.getLoginPassword(), loginAccount.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
			System.out.println(passwordMatched);

			userMatched = util.validateUsername(loginAccount,loginViewImpl.getLoginName());
			if (userMatched && passwordMatched) {
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
	
	public void initializeViewsAfterLogin(){
		//Main View
    	ExerciseDashViewImpl exerciseDashViewImpl = new ExerciseDashViewImpl();
    	DiaryDashViewImpl diaryDashViewImpl = new DiaryDashViewImpl();
        EmergencyViewImpl emergencyViewImpl = new EmergencyViewImpl();
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
    	new EmergencyViewPresenter(emergencyViewImpl,settingsModel,view);
    	new DiaryDashViewPresenter(diaryViewModel, diaryDashViewImpl, view);
    	
    	navigator.addView("HomeView", view);
        
	}
	
}
