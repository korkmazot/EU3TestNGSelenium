package com.cybertek.tests.day2_WebDriver_Basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.google.com");

        String title = driver.getTitle();

        System.out.println("Title = " + title);

        Thread.sleep(1000);

        driver.close();
    }
}
