package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SingletonTest {

    @Test
    public void test1(){

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);

    }
    @Test
    public void test2(){

        WebDriver driver = Driver.get();
        driver.get("https://www.google.com");
        Driver.closeDriver();

    }
    @Test
    public void test3(){
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");;
    }

}
