package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //String actualUrl after click button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
        }

        driver.quit();
    }


}
