package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class DBConnector {

	public LoginAccount getLoginAccount(String email){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("borderlinecare");
		EntityManager em = emFactory.createEntityManager();
		LoginAccount loginAccount = em.find(LoginAccount.class, email);
		System.out.println(loginAccount.getFirstName());
		return loginAccount;
	}

}
