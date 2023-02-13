package com.webTable;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParticularRowValue {
	ChromeDriver driver;
@BeforeMethod
public void openApp()	{
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	driver.get("https://www2.asx.com.au/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void openTable() {
	driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	driver.findElement(By.xpath("(//div[@id='pnProductNavContents']/h5)[2]")).click();
	
	
	List<WebElement> rowFive=driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[5]"));
	int rowSize=rowFive.size();
	System.out.println("Row size is    "+rowSize);
	Assert.assertEquals(rowSize, 1,"Row size did not match");
	
	boolean codeStatus=false;
	
	for(WebElement ele:rowFive) {
		String value=ele.getText();
		System.out.println(value);
		if(value.contains("2.140 0.080 (3.883%)")) {
			codeStatus=true;
			break;
		}
	}
	Assert.assertTrue(codeStatus, "could not find the value");
	
	driver.close();
}
}
