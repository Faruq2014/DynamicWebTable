package com.facebookRegistrationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;
import com.FacebookUtlities.ExcelUtils;
import com.FacebookUtlities.JDBC_Utils;
import com.facebookRegistrationPages.RegistrationPage;

public class RegistrationTestWithDB extends BaseTest {
	RegistrationPage registrationPage;
	String filePath = "src/test/resources/registration.xlsx";
	String sheetName = "sheet1";

	@Test
	public void registrationTest_Stewrt() {
		ExcelUtils ExcelUtils = new ExcelUtils(filePath, sheetName);
		JDBC_Utils jdbc = new JDBC_Utils();
		registrationPage = new RegistrationPage(driver);
		registrationPage.clickCreateButton();
		registrationPage.enterFirstName(jdbc.getFirstName());
		registrationPage.enterLastName(jdbc.getLastName());
		registrationPage.enterMobileOrEmail(jdbc.getEmail());
		registrationPage.reEnterEmail(jdbc.getEmail());
		registrationPage.enterPassword(jdbc.getPassword());
		String month = ExcelUtils.getCellData(2, 5);
		String day = ExcelUtils.getCellData(2, 6);
		String year = ExcelUtils.getCellData(2, 7);
		registrationPage.selectBirthday(month, day, year);
		registrationPage.selectGenderMale();
		// registrationPage.clickSignUpButton();
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		String accutualTitle = "Facebook - log in or sign up";
		if (!expectedTitle.contains(accutualTitle)) {
			takeScreenshot(driver, "rg.png");
		}
		Assert.assertEquals(accutualTitle, expectedTitle, "Facebook title did not match");
	}

}
