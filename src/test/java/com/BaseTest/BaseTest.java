package com.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.FacebookUtlities.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	ReadProperties properties; 

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			openApp();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			openApp();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			openApp();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

	}

	public void openApp() {
		properties= new ReadProperties();
		String url = properties.getUrl();
		driver.get(url);
		// maximizePage();
		driver.manage().window().maximize();

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}

	public void takeScreenshot(WebDriver driver, String fileName) {
		// String testName=result.getTestName();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File("screenshots/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}