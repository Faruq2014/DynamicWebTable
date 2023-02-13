package com.facebookLoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.facebookLoginPages.FacebookLoginPage;

public class LoginTest extends BaseTest {
	FacebookLoginPage loginPage;

	@Test
	public void testLogin() {
		driver.get("https://www.facebook.com/");
		loginPage = new FacebookLoginPage(driver);
		loginPage.enterEmail("your-email");
		loginPage.enterPassword("your-password");
		loginPage.clickLoginButton();
		String pageSource = driver.getPageSource();
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		String accutualTitle = "Log into Facebook";

		if (!expectedTitle.contains(accutualTitle)) {
			takeScreenshot(driver, "fb.png");
		}
		Assert.assertTrue(pageSource.contains("Facebook"));
		Assert.assertEquals(accutualTitle, expectedTitle, "Facebook title did not match");
	}

	@Test
	public void invalidLoginTest() {
		driver.get("https://www.facebook.com/");
		loginPage = new FacebookLoginPage(driver);
		loginPage.enterEmail("your-email");
		loginPage.enterPassword("your-password");
		loginPage.clickLoginButton();
		String pageSource = driver.getPageSource();
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		String accutualTitle = "Log into Facebook1";

		if (!expectedTitle.contains(accutualTitle)) {

			takeScreenshot(driver, "invalidfb.png");
		}
		Assert.assertTrue(pageSource.contains("Facebook"));
	}
}
