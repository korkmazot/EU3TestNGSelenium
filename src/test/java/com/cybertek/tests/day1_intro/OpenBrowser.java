package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args){

        //we have to enter this line every time we want to open chrome
        WebDriverManager.chromedriver().setup();

        //WebDriver represent the browser-we are creating driver for chrome browser
        //new ChromeDriver()=====>this part will open chrome browser
        WebDriver driver=new ChromeDriver();

        //.get(url) method used for navigation to page
        driver.get("http://cybertekschool.com");

    }
}
