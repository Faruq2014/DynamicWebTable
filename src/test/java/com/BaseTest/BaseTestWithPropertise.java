package com.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.FacebookUtlities.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestWithPropertise {
    protected WebDriver driver;
    private ReadProperties properties;
    
    @BeforeMethod
    public void setUp() {
        properties = new ReadProperties();
        String browser = properties.getBrowser();
        String url = properties.getUrl();
        
        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser specified in properties file.");
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
    public void takeScreenshot() {
        String screenshotName = "screenshot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("target", "screenshots", screenshotName);
        
        try {
            Files.createDirectories(destination.getParent());
            Files.move(screenshot.toPath(), destination);
            System.out.println("Screenshot saved: " + destination.toAbsolutePath().toString());
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }
    }
}