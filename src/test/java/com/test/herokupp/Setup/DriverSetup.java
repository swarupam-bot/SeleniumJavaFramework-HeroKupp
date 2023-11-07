package com.test.herokupp.Setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class DriverSetup {
    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
    public WebDriver Driver;

    //Driver setup for opening the browser
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/swarupamkumar/IdeaProjects/AssignmentCAWStudios/Driver/chromedriver");

        Driver = new ChromeDriver();

        Driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        Driver.manage().window().maximize();

        ExtentTest test = extent.createTest("Launch Browser and website");

        extent.attachReporter(spark);


    }

    //closing the driver
    @AfterTest
    public void closeDriver() {
        extent.flush();
        Driver.close();

    }

}
