package com.FacebookJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class DB_Operations {
	public synchronized HashMap<String, String> getSqlResultInMap(String sqlQuery) { 
        HashMap<String, String> data_map = new HashMap<>();

		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String url ="jdbc:sqlserver://DESKTOP-INQUNRP\\MSSQLSERVER;"+"databaseName=FaruqAcademy;";

			String user="Faruq";
			String password="1234";
			Connection con=DriverManager.getConnection(url,user,password); 		

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(sqlQuery);  
            ResultSetMetaData rmd = rs.getMetaData();
             System.out.println(rs); // how many data set 
            while (rs.next()) {            
                for (int i = 1; i <= rmd.getColumnCount(); i++) {
                    data_map.put(rmd.getColumnName(i), rs.getString(i));
                }
            }
            System.out.println(data_map); // print all the map
			con.close();  
		}catch(Exception e){ System.out.println(e);}
		return data_map;  
	}  

	public static void main(String[] args) {
		String sid1 = "SELECT * FROM [FaruqAcademy].[dbo].[account] where first_name='Faruq'";		
		DB_Operations db = new DB_Operations();
		HashMap<String, String> dbData=db.getSqlResultInMap(sid1);
		System.out.println(dbData.get("first_name"));
		System.out.println(dbData.get("last_name"));		
		System.out.println(dbData.get("user_name"));
		System.out.println(dbData.get("password"));
		System.out.println(dbData.get("email_id"));
		System.out.println(dbData.get("mobile_number"));
		
		//example of id which is int data type
		String sid2 = "SELECT * FROM [FaruqAcademy].[dbo].[Students] where studentId=2";
		HashMap<String, String> dbData2=db.getSqlResultInMap(sid2);
		System.out.println(dbData2.get("firstname"));
		System.out.println(dbData2.get("lastname"));
		System.out.println(dbData2.get("phone"));
		System.out.println(dbData2.get("phone"));
		System.out.println(dbData2.get("enrolldate"));
		System.out.println(dbData2.get("studentId"));

	}

}
