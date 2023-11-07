package com.test.herokupp.Utils;


import com.test.herokupp.Setup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class CommonUtils extends DriverSetup {


//Util for waiting for webElement to present
    public static void waitForElement(WebDriver Driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        Reporter.log("Minimum timeout for 10 sec");
    }

}
