package com.facebookRegistrationTests;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;
import com.FacebookJdbc.DB_Operations;
import com.FacebookUtlities.ExcelUtils;
import com.facebookRegistrationPages.RegistrationPage;

public class RegistrationTestWithJdbc extends BaseTest {
	RegistrationPage registrationPage;
	 String filePath="src/test/resources/registration.xlsx";
	 String sheetName="sheet1";
  @Test
  public void registrationTest_Stewrt() {
	  String select = "SELECT * FROM [FaruqAcademy].[dbo].[account] where first_name='Faruq'";		
		DB_Operations db = new DB_Operations();
		HashMap<String, String> dbData=db.getSqlResultInMap(select);
    //driver.get("https://www.facebook.com/");
    registrationPage = new RegistrationPage(driver);
    registrationPage.clickCreateButton();
    registrationPage.enterFirstName(dbData.get("first_name"));
    registrationPage.enterLastName(dbData.get("last_name"));
    registrationPage.enterMobileOrEmail(dbData.get("mobile_number"));
    registrationPage.reEnterEmail(dbData.get("email_id"));
    registrationPage.enterPassword(dbData.get("password"));
    //getting data from excel
    ExcelUtils ExcelUtils = new ExcelUtils(filePath,sheetName);
    String month=ExcelUtils.getCellData(2, 5);
    String day=ExcelUtils.getCellData(2, 6);
    String year=ExcelUtils.getCellData(2, 7);
    registrationPage.selectBirthday(month,day,year);
    registrationPage.selectGenderMale();
    //registrationPage.clickSignUpButton();
    String expectedTitle = driver.getTitle();
	System.out.println(expectedTitle);
	String accutualTitle = "Facebook - log in or sign up";
	if (!expectedTitle.contains(accutualTitle)) {
		takeScreenshot(driver, "rg.png");
	}
	Assert.assertEquals(accutualTitle, expectedTitle, "Facebook title did not match");
}
  
  //@Test
  public void registrationTest() {
    //driver.get("https://www.facebook.com/");
    registrationPage = new RegistrationPage(driver);
    registrationPage.clickCreateButton();
    registrationPage.enterFirstName("Stecy");
    registrationPage.enterLastName("MacMillan");
    registrationPage.enterMobileOrEmail("Stewrt@MacMillan.com");
    registrationPage.reEnterEmail("Stecy@MacMillan.com");
    registrationPage.enterPassword("password");
    registrationPage.selectBirthday("13", "Jan", "1970");
    registrationPage.selectGenderFemale();
    //registrationPage.clickSignUpButton();
    String expectedTitle = driver.getTitle();
	System.out.println(expectedTitle);
	String accutualTitle = "Facebook - log in or sign up";
	if (!expectedTitle.contains(accutualTitle)) {
		takeScreenshot(driver, "rg.png");
	}
	Assert.assertEquals(accutualTitle, expectedTitle, "Facebook title did not match");
}
  }


