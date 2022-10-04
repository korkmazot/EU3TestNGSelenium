package com.cybertek.tests.day4_Basic_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagName_Locator {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.tagName("input"));

        fullNameInput.sendKeys("Mike Smith with TagName");

        //WebElement emailInput = driver.findElement(By.tagName("input"));

        driver.findElement(By.tagName("input")).sendKeys("mike@smith.com");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
