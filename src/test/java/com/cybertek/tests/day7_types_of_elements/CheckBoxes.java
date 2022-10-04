package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        Assert.assertFalse(checkbox1.isSelected(),"Verify checkbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify checkbox2 is selected");

        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"Verify checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify checkbox2 is selected");

        Thread.sleep(1000);
        driver.quit();

    }

}
