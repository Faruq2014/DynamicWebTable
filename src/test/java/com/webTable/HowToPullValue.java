package com.webTable;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToPullValue {
	ChromeDriver driver;
@BeforeTest
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
	
	/*
	 * //*[@id="home_top_five"]/div/div[1]/div/div[1]/table/tr[1]
	 * tr[1]== this means table row, so if i take the [1] row index away, then i will get list of row
	 */
	List<WebElement> row=driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
	int rowSize=row.size();
	System.out.println("Row size is    "+rowSize);
	
	/*
	 * //*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td[1]
	 * td[1]==this means table column index td[1], if i take [1] away then i will get list of column. 
	 */
	
	List<WebElement> col=driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td"));
	int colSize=col.size();
	System.out.println("column size is  "+colSize);
	
	// just to make sure cell values are printing individually.
	System.out.println(driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td[1]")).getText());
	
	// running i loop and j loop to print all the value in the table.
	for(int i=2; i<=rowSize;i++) {
		for(int j=1; j<=colSize; j++) {
		System.out.print(driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr["+i+"]/td["+j+"]"))
			.getText()+" ");
		}
		System.out.println();
	}
	
	
	driver.close();
}
}
