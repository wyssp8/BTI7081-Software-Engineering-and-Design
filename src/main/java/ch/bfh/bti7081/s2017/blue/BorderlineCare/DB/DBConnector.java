package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

public class DBConnector {

private String dbms = "mysql";
private String serverName = "localhost";
private String portNumber = "3306";
private String dbname = "borderlinecare";
private Connection conn = null;


public Connection getConnection() throws SQLException {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("borderlinecare");
	EntityManager em = emFactory.createEntityManager();
	Contact find = em.find(Contact.class, 1);
    Properties connectionProps = new Properties();
    connectionProps.put("user", "root");
    connectionProps.put("password", "22JrCCM5$");
    connectionProps.put("useSSL","false");
    connectionProps.put("serverTimezone", "UTC");
    
    conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/" +
                   this.dbname,
                   connectionProps);
   
    System.out.println(connectionProps);
    System.out.println("Connected to database: " + this.dbname);
    return conn;
    
}
public static void main(String[] args) {
	try {
		new DBConnector().getConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
