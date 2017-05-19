package ch.bfh.bti7081.s2017.blue.BorderlineCare.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

private String dbms = "mysql";
private String serverName = "localhost";
private String portNumber = "3306";
private String dbname = "borderlinecare";
private Connection conn = null;


public Connection getConnection() throws SQLException {
    
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
