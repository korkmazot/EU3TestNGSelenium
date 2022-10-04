package com.cybertek.tests.day7_testing;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("----Before Class----");
        System.out.println("executed one time before the class");

    }

    @Test
    public void test1(){
        System.out.println("First test case");

    }
    @Test
    public static void test2(){
        System.out.println("Second test case");

    }
    @Ignore
    @Test
    public static void test3(){
        System.out.println("Third test case");

    }
    @BeforeMethod
    public void setUp(){
        System.out.println("----Before Method----");
        System.out.println("WebDriver,Opening Browser");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("----After Method----");
        System.out.println("Closing Browser,Quit");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("----After Class----");
        System.out.println("Some Reporting Code Here");
    }
}
