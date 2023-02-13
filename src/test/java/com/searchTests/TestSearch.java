package com.searchTests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;

public class TestSearch extends BaseTest {
	 WebDriverWait wait;
  @Test
  public void testSearch() {
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
    searchBox.sendKeys("selenium webdriver");
    searchBox.submit();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    String pageSource = driver.getPageSource();
    if (!pageSource.contains("Selenium")) {
      takeScreenshot(driver, "search_failed.png");
    }
    Assert.assertTrue(pageSource.contains("Selenium"));
  }

}
