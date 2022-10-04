package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

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
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames ======>>
        // 1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main html) ====>> goes back to first frame,useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.Switch with index
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.Switch using web element ====>> Locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //Switching to Frame Top
        driver.switchTo().frame("frame-top");

        //Frame top has 3 frame under Left, Middle and Right
        //Switch to Middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //goes back to top frame
        driver.switchTo().parentFrame();

        //Switch to Right frame with Index
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

    }
