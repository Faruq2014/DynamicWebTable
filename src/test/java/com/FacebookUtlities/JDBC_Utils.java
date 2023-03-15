package com.FacebookUtlities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Utils {
	
public String url = "jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;" + "databaseName=FaruqAcademy;";
public String user = "Faruq";
public String password = "1234";
String selectAccount = "SELECT * FROM account where first_name='Faruq'";
String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";

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

	public String getLastName() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("last_name");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}
	
	public String getUserName() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("user_name");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}

	
	public String getEmail() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("email_id");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}
	
	
	public String getMobile() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("mobile_number");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}
	
	public String getPassword() {
		try { 
			Class.forName(driver);
		Connection	connection=DriverManager.getConnection(url, user, password);
		Statement statement=connection.createStatement();
			 ResultSet studentResultSet=statement.executeQuery(selectAccount);		 
		 while(studentResultSet.next()) {
			String dBFirstName= studentResultSet.getString("mobile_number");
			System.out.println(dBFirstName);
		 }
		 connection.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return driver;	
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		JDBC_Utils db= new JDBC_Utils();
		//db.select();
		db.getFirstName();

	}

}
