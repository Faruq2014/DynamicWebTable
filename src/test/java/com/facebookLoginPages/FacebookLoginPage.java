package com.facebookLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	WebDriver driver;
	public FacebookLoginPage(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	  }

	@FindBy(id = "email")
	  private WebElement getEmail;

	  @FindBy(id = "pass")
	  private WebElement getPassword;

	  @FindBy(name = "login")
	  private WebElement getLoginButton;

	  
	  public void enterEmail(String email) {
	    getEmail.sendKeys(email);
	  }

	  public void enterPassword(String password) {
	    getPassword.sendKeys(password);
	  }

	  public void clickLoginButton() {
	    getLoginButton.click();
	  }


}
