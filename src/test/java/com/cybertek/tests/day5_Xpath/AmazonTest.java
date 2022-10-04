package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    //go to Amazon.com => search for selenium => click search button => verify 1-48 of 384 results for "selenium"

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("Selenium");

        //click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String resultText = result.getText();

        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of 199 results for";

        if(expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult= " + expectedResult);
            System.out.println("resultText= " + resultText);
        }
        driver.quit();


    }
}
