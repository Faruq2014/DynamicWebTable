package com.FacebookUtlities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadProperties {
	    
 private Properties props;
    
    public ReadProperties()  { 
    	props = new Properties();
    try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
        props.load(fis);
    } catch (IOException e) {
        System.out.println("Error loading properties file: " + e.getMessage());
    }
}
    
    public String getBrowser() {
        return props.getProperty("browser");
    }
    
    public String getUrl() {
        return props.getProperty("url");
    }
    public String getUserName() {
        return props.getProperty("userName");
    }
    
    public String getPassword() {
        return props.getProperty("password");
    }
    
    public static void main(String[] args) {
    	ReadProperties readProperties= new ReadProperties();
    	System.out.println(readProperties.getUrl());
    	
    }
}
