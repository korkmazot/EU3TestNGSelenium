package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        blueRadioBtn.getAttribute("value");

        //get the value of type attribute
        System.out.println(blueRadioBtn.getAttribute("type"));

        //get the value of name attribute
        System.out.println(blueRadioBtn.getAttribute("name"));

        //checked attribute is true or false
        System.out.println(blueRadioBtn.getAttribute("checked"));

        //tryint to get attribute that does not exist
        System.out.println(blueRadioBtn.getAttribute("href"));

        //full name of address
        System.out.println(blueRadioBtn.getAttribute("outerHTML"));

        Thread.sleep(1000);
        driver.quit();

    }
    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));
        System.out.println(button2.getAttribute("outerHTML"));

        String outerHTML = button2.getAttribute("outerHTML");
        System.out.println(outerHTML.contains("button2"));

        System.out.println("Inner HTML: " + button2.getAttribute("innerHTML"));

        Thread.sleep(1000);
        driver.quit();
    }
}
