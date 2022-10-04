package com.cybertek.tests.day11_Webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void printTable(){

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders() {               //how many columns we have??
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() : " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

    }
    @Test
    public void printTableSize() {

        //how many columns we have??
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() : " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
        System.out.println("=============");

        //how many rows we have??
        List<WebElement> allRowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeaders.size() : " + allRowsWithHeaders.size());

        for (WebElement allRowsWithHeader : allRowsWithHeaders) {
            System.out.println(allRowsWithHeader.getText());
        }
        System.out.println("=============");

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeaders.size() : " + allRowsWithoutHeaders.size());

        for (WebElement allRowsWithoutHeader : allRowsWithoutHeaders) {
            System.out.println(allRowsWithoutHeader.getText());
        }

    }
    @Test
    public void getRow(){

        WebElement row1 = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[1]"));
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[2]"));
        WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[3]"));
        WebElement row4 = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[4]"));

        System.out.println(row1.getText());
        System.out.println(row2.getText());
        System.out.println(row3.getText());
        System.out.println(row4.getText());

        System.out.println("--------------------------");

        //Second way with loop

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));

        for(int i=1; i<=numRows.size(); i++){

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]"));

            System.out.println(i + "-" + row.getText());
        }
    }

    @Test
    public void getAllCellInOneRow(){

        List<WebElement> allcellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[1]/td"));

        for (WebElement element : allcellsInOneRow) {
            System.out.println(element.getText());

        }
    }
    @Test
    public void getASingleCellByIndex() {

        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[3]/td[5]"));

        System.out.println(singleCell.getText());

    }
    @Test
    public void printallCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("ColNumber : " + colNumber);
        System.out.println("rowNumber : " + rowNumber);

        //iterate through each row on the table
        for (int i=1; i<=rowNumber; i++) {

            for(int j=1; j<=colNumber; j++){
                String cellXpath = "//table[@id='table1']//tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());

            }
        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "Jason";

        String xpath = "//table[@id='table1']//td[.='"+ firstName + "']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeaders.size();
    }


}
