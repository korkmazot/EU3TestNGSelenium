package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);
        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("option.size() = " + options.size());

        //print options one by one with shortcut iter+enter
        for (WebElement option : options) {
            System.out.println(option.getText());

        }

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is select a state
        String expectedOption = "Select a State";
        String actualOption =  stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");

        //How to select options from dropdown ======> Select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");

        //Select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);
        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");


    }

}
