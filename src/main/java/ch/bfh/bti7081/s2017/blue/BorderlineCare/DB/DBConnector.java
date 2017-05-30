package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class DBConnector {

	private String accountEmail;
	private static DBConnector dbConnector = null;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("borderlinecare");
	private EntityManager em = emFactory.createEntityManager();

	private DBConnector(){
	}
	
	public static DBConnector getDBConnector(){
		if (dbConnector == null) {
			return dbConnector = new DBConnector();
		}
		return dbConnector;
	}
	
	public LoginAccount getLoginAccount() {
		LoginAccount loginAccount = em.find(LoginAccount.class, accountEmail);
		return loginAccount;
	}

	public void refreshData(LoginAccount loginAccount) {
		em.getTransaction().begin();
		em.persist(loginAccount);
		em.getTransaction().commit();
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	
}
