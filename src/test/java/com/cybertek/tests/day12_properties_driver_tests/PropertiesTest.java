package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");
        System.out.println("Browser Type : " + browserType);

        String url = ConfigurationReader.get("url");
        System.out.println("URL is : " + url);

    }
    @Test
    public void OpenBrowserWithConf() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        Thread.sleep(2000);
        driver.quit();
    }


}
