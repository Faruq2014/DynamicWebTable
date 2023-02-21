package com.facebookRegistrationTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;
import com.FacebookUtlities.ExcelUtils;
import com.facebookRegistrationPages.RegistrationPage;

public class RegistrationTest extends BaseTest {
	RegistrationPage registrationPage;
	 String filePath="src/test/resources/registration.xlsx";
	 String sheetName="sheet1";
  @Test
  public void registrationTest_Stewrt() {
	  ExcelUtils ExcelUtils = new ExcelUtils(filePath,sheetName);
    //driver.get("https://www.facebook.com/");
    registrationPage = new RegistrationPage(driver);
    registrationPage.clickCreateButton();
    registrationPage.enterFirstName(ExcelUtils.getCellData(1, 0));
    registrationPage.enterLastName(ExcelUtils.getCellData(1, 1));
    registrationPage.enterMobileOrEmail(ExcelUtils.getCellData(1, 2));
    registrationPage.reEnterEmail(ExcelUtils.getCellData(1, 3));
    registrationPage.enterPassword(ExcelUtils.getCellData(1, 4));
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


