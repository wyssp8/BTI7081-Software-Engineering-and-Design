package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class DBConnector {

	public void getConnection(String email){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("borderlinecare");
		EntityManager em = emFactory.createEntityManager();
		LoginAccount find = em.find(LoginAccount.class, email);
		System.out.println(find.getFirstName());
	}

}
