package com.cybertek.tests.day7_testing;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");

    }
    @Test
    public void test1(){
        System.out.println("----Test 1----");

        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test2(){
        System.out.println("----Test 2----");
        Assert.assertEquals("test2","test2","Verify test2");

    }
    @Test
    public void test3(){
        System.out.println("----Test 3----");
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title start with Cby");

    }
    @Test
    public void test4(){
        System.out.println("----Test 4----");
        //verify email contains @
        String email = "mike@smith.com";
        Assert.assertTrue(email.contains("@"),"Verity email contains @");

    }
    @Test
    public void test5(){
        System.out.println("----Test 5----");
        Assert.assertFalse(0>1,"Verify that 0 is not greater than 1");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");

    }
}
