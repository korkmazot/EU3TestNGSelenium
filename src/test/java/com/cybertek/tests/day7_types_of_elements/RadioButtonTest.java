package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = "  + redRadioBtn.isSelected());

        //verify blue is selected red is not selected
        Assert.assertTrue(blueRadioBtn.isSelected(),"Verify that blue radio button is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"Verify that red radio button is selected");

        //how tp click button
        redRadioBtn.click();

        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify that blue radio button is selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"Verify that red radio button is selected");

        Thread.sleep(2000);
        driver.quit();
    }
}
