package com.cybertek.tests.day10_File_Upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){

        //Users/omert/IdeaProjects/EU3TestNGSelenium/src/test/resources/textfile.txt

        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);

        String filePath = "src\\test\\resources\\textfile.txt";

        String fullPath = projectPath + "\\" + filePath;

        System.out.println(fullPath);



    }
}
