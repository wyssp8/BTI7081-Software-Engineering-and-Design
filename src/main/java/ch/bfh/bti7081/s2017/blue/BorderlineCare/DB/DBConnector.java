package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class DBConnector {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("borderlinecare");
	private EntityManager em = emFactory.createEntityManager();

	public LoginAccount getLoginAccount(String email) {
		LoginAccount loginAccount = em.find(LoginAccount.class, email);
		return loginAccount;
	}

	public void refreshData(LoginAccount loginAccount) {
		em.getTransaction().begin();
		em.persist(loginAccount);
		em.getTransaction().commit();
	}
}
