package com.facebookRegistrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Create new account']")
	private WebElement createNewAccount;

	@FindBy(how = How.NAME, using = "firstname")
	private WebElement firstNameField;

	@FindBy(how = How.NAME, using = "lastname")
	private WebElement lastNameField;

	@FindBy(how = How.NAME, using = "reg_email__")
	private WebElement mobileOrEmailField;

	@FindBy(how = How.NAME, using = "reg_email_confirmation__")
	private WebElement reEnterEmailField;

	@FindBy(how = How.NAME, using = "reg_passwd__")
	private WebElement passwordField;

	@FindBy(how = How.ID, using = "day")
	private WebElement birthdayDayField;

	@FindBy(how = How.ID, using = "month")
	private WebElement birthdayMonthField;

	@FindBy(how = How.ID, using = "year")
	private WebElement birthdayYearField;

	@FindBy(how = How.XPATH, using = "//input[@value='2']")
	private WebElement genderFemaleRadioButton;

	@FindBy(how = How.XPATH, using = "//input[@value='1']")
	private WebElement genderMaleRadioButton;

	@FindBy(how = How.NAME, using = "websubmit")
	private WebElement signUpButton;

	public void clickCreateButton() {
		createNewAccount.click();
	}

	public String enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
		return firstName;
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterMobileOrEmail(String mobileOrEmail) {
		mobileOrEmailField.sendKeys(mobileOrEmail);
	}

	public void reEnterEmail(String reEnterEmail) {
		reEnterEmailField.sendKeys(reEnterEmail);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectBirthday( String month,String day, String year) {
		birthdayMonthField.sendKeys(month);
		birthdayDayField.sendKeys(day);
		birthdayYearField.sendKeys(year);
	}

	public void selectGenderFemale() {
		genderFemaleRadioButton.click();
	}
	
	public void selectGenderMale() {
		genderMaleRadioButton.click();
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}
}
