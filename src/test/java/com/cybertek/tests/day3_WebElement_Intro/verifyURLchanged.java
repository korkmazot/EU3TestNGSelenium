package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter email and SendKey()
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(2000);

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ExpectedUrl : " + expectedUrl);
            System.out.println("ActualUrl : " + actualUrl);
        }
        driver.quit();

    }
}
