package com.cybertek.tests.day4_Basic_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Name_Locator_Test {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //make browser fullscreen
       // driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //put some email and sign up button
//        WebElement emailInput = driver.findElement(By.name("email"));
//        emailInput.sendKeys("mike@smith.com");

        //lazy way
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        driver.findElement(By.name("wooden_spoon")).click();

//        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
//        signUpButton.click();


    }
}


