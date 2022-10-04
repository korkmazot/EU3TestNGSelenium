package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 0; i <= 10; i++) {

            String xpathImg = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(3000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user"+i+"']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(), "verify user "+i+" is displayed");

        }

    }
    @Test
    public void oneImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("img"));

        Actions actions = new Actions(driver);

        Thread.sleep(3000);

        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(),"Verify text 1 is displayed");

    //    Assert.assertEquals(text1.isDisplayed(),"Verify text 1 is displayed");

    }
}
