package com.erp.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseErpTest {
    private Properties properties;
    public static WebDriver driver;

    public BaseErpTest() {

        try {
            String filepathRenamed = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(filepathRenamed);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void BrowserSetUp() {
        String browserName = getBrowserName();
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(getBaseUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    } //baseurl

    public String getUserName() {
        return properties.getProperty("userName");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getBrowserName() {
        return properties.getProperty("browserName");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}

