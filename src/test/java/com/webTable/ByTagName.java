package com.webTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByTagName {
	ChromeDriver driver;
@BeforeMethod
public void openApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://money.rediff.com/indices");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void openTable() {
	System.out.println("heloo");
	driver.findElement(By.id("showMoreLess")).click();
	WebElement webTable=driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
	List<WebElement> row=webTable.findElements(By.tagName("tr"));
	int rowSize=row.size();
	System.out.println(rowSize);
	
	for(int i=1; i<=rowSize; i++) {
		List<WebElement> column=row.get(i).findElements(By.tagName("td"));
		int columnSize=column.size();
		
		for(int j=0; j<=columnSize; j++) {
			String cellData=column.get(j).getText();
			System.out.println(cellData);
		}
		
	}
	
}

}
