package com.FacebookJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Utils {
	
public String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
public String user = "Faruq";
public String password = "1234";
String selectAccount = "SELECT * FROM account where first_name='Faruq'";
String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public void select() {
		try { // sql server driver code
		    //oracle.jdbc.driver.OracleDriver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
		
			String selectAccount = "SELECT * FROM account";
		
		 ResultSet studentResultSet=statement.executeQuery(selectAccount);
		 
		 while(studentResultSet.next()) {
			System.out.println(studentResultSet.getString("first_name")); 
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
	}
	
	public void selectSpecificUser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
		
			
		
		 ResultSet studentResultSet=statement.executeQuery(selectAccount);
		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("first_name");
			System.out.println(dBFirstName); 
			System.out.println(studentResultSet.getString("last_name"));
			System.out.println(studentResultSet.getString("user_name"));
			System.out.println(studentResultSet.getString("password"));
			System.out.println(studentResultSet.getString("email_id"));
			System.out.println(studentResultSet.getString("mobile_number"));

		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//
	public String getFirstName() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("first_name");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}

	
	
	public static void main(String[] args) {
		DB_Utils db= new DB_Utils();
		//db.select();
		db.getFirstName();

	}

}
