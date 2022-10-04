package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //Task > verify username inputbox is not displayed > click start button > verify username displayed on the screen
        Assert.assertFalse(usernameInput.isSelected(),"Verify inputbox is NOT displayed");
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);
        Assert.assertTrue(usernameInput.isDisplayed(),"Verify username is displayed");

    }
}
