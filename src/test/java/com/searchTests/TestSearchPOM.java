package com.searchTests;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseTest.BaseTest;
import com.searchPages.SearchPage;

public class TestSearchPOM extends BaseTest {
	 WebDriverWait wait;
	 SearchPage searchPage;
  @Test
  public void testSearch() {
	  searchPage=new SearchPage(driver);
	  searchPage.search("Java");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    String pageSource = driver.getPageSource();
    if (!pageSource.contains("Java")) {
      takeScreenshot(driver, "search_failed.png");
    }
    Assert.assertTrue(pageSource.contains("Java"));
  }
  @Test
  public void testSearchSelenium() {
	  searchPage=new SearchPage(driver);
	  searchPage.search("selenium webdriver");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    String pageSource = driver.getPageSource();
    if (!pageSource.contains("Fabiha")) {
      takeScreenshot(driver, "search_failed.png");
    }
    Assert.assertTrue(pageSource.contains("Selenium"));
  }
}
