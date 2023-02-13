package com.facebookRegistrationTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;
import com.facebookRegistrationPages.RegistrationPage;

public class RegistrationTest extends BaseTest {
	RegistrationPage registrationPage;
  @Test
  public void registrationTest_Stewrt() {
    driver.get("https://www.facebook.com/");
    registrationPage = new RegistrationPage(driver);
    registrationPage.clickCreateButton();
    registrationPage.enterFirstName("Mark");
    registrationPage.enterLastName("MacMillan");
    registrationPage.enterMobileOrEmail("Mark@MacMillan.com");
    registrationPage.reEnterEmail("Stewrt@MacMillan.com");
    registrationPage.enterPassword("password");
    registrationPage.selectBirthday("13", "Jan", "1970");
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
  
  @Test
  public void registrationTest() {
    driver.get("https://www.facebook.com/");
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


