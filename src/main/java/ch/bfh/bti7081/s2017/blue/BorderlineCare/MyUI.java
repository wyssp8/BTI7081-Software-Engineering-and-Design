package ch.bfh.bti7081.s2017.blue.BorderlineCare;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.SignUpViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.login.LoginViewPresenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.login.SignUpViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.LoginViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.SignUpViewImpl;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private static final long serialVersionUID = 8756061847229359826L;
	private static boolean startup = true;
	private Navigator navigator;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
		 this.navigator = new Navigator(this, this);
		
    	
    	//Login View
    	LoginViewModel loginViewModel = new LoginViewModel();
    	LoginViewImpl loginViewImpl = new LoginViewImpl();
    	LoginViewPresenter loginViewPresenter = new LoginViewPresenter(loginViewModel, loginViewImpl, navigator);
    	
    	//SignUp View
    	SignUpViewModel signUpViewModel = new SignUpViewModel();
    	SignUpViewImpl signUpViewImpl = new SignUpViewImpl();
    	new SignUpViewPresenter(signUpViewModel,signUpViewImpl, navigator,loginViewModel);
    	
        navigator.addView("LoginView", loginViewImpl);
        navigator.addView("SignUpView", signUpViewImpl);
       // navigator.navigateTo("HomeView");
        
        boolean isLoggedIn = getSession().getAttribute("user") != null;       
        
        if(startup){
        	//Initialize LoginView the first time(prevents the load of that view after a refresh)
        	getNavigator().navigateTo("LoginView");	
        	startup=false;
        }
        if(isLoggedIn&&startup){
        	loginViewPresenter.initializeViewsAfterLogin();
        	getNavigator().navigateTo("HomeView");	
        } else{
        	loginViewPresenter.initializeViewsAfterLogin();
        	getNavigator().navigateTo("HomeView");
        }
        

        //On every view change, check if logged in. If not, go back to loginview
        getNavigator().addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {

                // Check if a user has logged in
                boolean isLoggedIn = getSession().getAttribute("user") != null;
                boolean isLoginView = event.getNewView() instanceof LoginViewImpl;
                boolean isSignUpView = event.getNewView() instanceof SignUpViewImpl;
                
                System.out.println("logged: "+isLoggedIn+" loginView: "+isLoginView+" signup: "+isSignUpView);
                
                if (!isLoggedIn&&!isSignUpView&&!isLoginView) {
                    // Redirect to login view always if a user has not yet logged in
                    getNavigator().navigateTo("LoginView");
                    return false;
                } else if (isLoggedIn && isLoginView) {
                    // If someone tries to access to login view while logged in, then cancel
                    return false;
                }
                return true;
            }
            @Override
            public void afterViewChange(ViewChangeEvent event) {

            }
        });
    }
	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 7729956322024855965L;
    }
}
