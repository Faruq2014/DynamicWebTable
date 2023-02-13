package com.webTable;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	ChromeDriver driver;

	/**
	 * opening the application
	 */
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www2.asx.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is about
	 * how to use find elements
	 * how to use enhance loop
	 * how to use web table
	 * how to find cell values from the table
	 * how to assert cell values from web table
	 */
	@Test
	public void openTable() {
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.xpath("(//div[@id='pnProductNavContents']/h5)[2]")).click();
		// Find elements method
		// it will bring list of data so we should use list
		// WebElement data type
		List<WebElement> row = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
		int rowSize = row.size();
		System.out.println("Row size is    " + rowSize);
		Assert.assertEquals(rowSize, 6, "Row size did not match");
		// Setting up boolean flag
		boolean codeStatus = false;
		// Enhance for loop
		for (WebElement ele : row) {
			String value = ele.getText();
			System.out.println(value);
			if (value.contains("IMUGENE LIMITED")) {

				// by default flag is false,
				// but if any of the value contains user input value then
				// flag become true
				codeStatus = true;
				break;
				// as soon as it find the user input the loop stop running
			}
		}
		Assert.assertTrue(codeStatus, "could not find the value");
		// if user input did not match at all after running all the value

		driver.close();
		// if everything goes well, driver will close
	}
}
