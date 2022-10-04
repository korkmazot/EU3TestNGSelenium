package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    //Verify Radio Button ==>> Open Browser ==>> Login as Driver ==>> Go to Activities ==>> Calendar Events ==>>
    //Click on repeat ==>> Verify that repeat every days is checked ==>> Verify that repeat weekday is not checked

    @Test

    public void test1() {

        LoginPage loginPage = new LoginPage();
                    //Login as Driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
                    //Go to Activities ==>> Calendar Events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
                    //Click on create calendar events
       // calendarEventsPage.waitUntilLoaderScreenDisappear();
       // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
                     //click on repeat
        createCalendarEventsPage.repeat.click();
                     //verify that repeat weekday is not checked
        //Assert.assertEquals(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat days is selected");

        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");

    }

    @Test

    public void test2() {

        LoginPage loginPage = new LoginPage();
        //Login as Driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities ==>> Calendar Events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        // calendarEventsPage.waitUntilLoaderScreenDisappear();
        // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        //click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();
                //Verify  that repeat options are Daily,Weekly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();

        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }
        //ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"Verify Daily Weekly Monthly Yearly");
    }


}
