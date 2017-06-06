package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.login;



import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.SignUpViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.SignUpViewButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.login.SignUpViewImpl;

public class SignUpViewPresenter extends CustomComponent implements SignUpViewButtonClickListener,View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2288314058697414321L;
	private SignUpViewModel signUpViewModel;
	private SignUpViewImpl signUpViewImpl;
	private LoginViewModel loginViewModel;
	
	private Navigator navigator;
	private String generatedSecuredPasswordHash;
	
	public SignUpViewPresenter(SignUpViewModel signUpViewModel, SignUpViewImpl signUpViewImpl, Navigator navigator,LoginViewModel loginViewModel) {
		this.signUpViewModel = signUpViewModel;
		this.signUpViewImpl = signUpViewImpl;
		this.loginViewModel = loginViewModel;
		this.navigator = navigator;
		signUpViewImpl.addListener(this);
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
		
		try {
			generatedSecuredPasswordHash = generateStorngPasswordHash(signUpViewImpl.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
        System.out.println(generatedSecuredPasswordHash);
		
        LoginAccount loginaccount = new LoginAccount(
				signUpViewImpl.getFirstName(),
				signUpViewImpl.getLastName(),
				signUpViewImpl.getStreet(),
				signUpViewImpl.getZipCode(),
				signUpViewImpl.getCity(),
				signUpViewImpl.getEmail(),
				generatedSecuredPasswordHash);
        
		loginViewModel.setLoginAccount(loginaccount);
		try {
			DBConnector.getDBConnector().addNewLoginAccountToDB(loginaccount);
		} catch (Exception e) {
			System.err.println("EMail-Adresse bereits registriert");
		}
		
					
		//to do: clear all textfields
		navigator.navigateTo("LoginView");
	}

	@Override
	public void cancelButtonClick() {
		navigator.navigateTo("LoginView");
		
	}
	
	
	//Generate secure password with PBKDF2 encryption
	private static String generateStorngPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();
         
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
     
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
     
    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
    
}
