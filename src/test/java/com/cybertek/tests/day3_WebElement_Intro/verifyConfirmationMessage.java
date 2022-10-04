package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter email and SendKey()
        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "mike@smith.com";
        emailInputBox.sendKeys(expectedEmail);

        //1.getText()=====> it will work %99 and will return string
        //2.getAttribute("value")=====>second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail =" + actualEmail);

        //verify that email is displayed in the box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(3000);

        //verify that confirmation message says "Your emails been sent!"
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfirmationMessage.getText());

        //save expected message
        String expectedMessage = "Your email's been sent!";
        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
        driver.quit();
    }
}
