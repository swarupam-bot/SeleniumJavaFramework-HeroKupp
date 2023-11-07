package com.test.herokupp.Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.herokupp.Utils.UtilsWebElements;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.test.herokupp.Utils.CommonUtils.waitForElement;

public class HeroKuppHTMLPage extends UtilsWebElements {

    String filePath = "/Users/swarupamkumar/IdeaProjects/AssignmentCAWStudios/src/test/java/com/test/herokupp/Utils/testData.json";
    String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
    JSONArray jsonData = new JSONArray(jsonContent);

    public HeroKuppHTMLPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void TCInsertDataInTable(ExtentReports extent, WebDriver Driver) throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Insert json Data In Table");

        waitForElement(Driver, pageName, 10);
        //clicking on Table Data Dropdown
        if (tableDataDropDown.isEnabled()) {
            Reporter.log("TableData DropDown is enabled.");
            tableDataDropDown.click();
            Reporter.log("TableData DropDown is clicked.");
            test.pass("Able to click on TableData DropDown ");

        } else {
            Reporter.log("TableData DropDown is not enabled.");
            test.fail("Not able to click on TableData DropDown ");

        }

        //Entering the Data in TextBox
        if (textBox.isEnabled()) {
            Reporter.log("textBox is enabled.");


            textBox.clear();

            textBox.sendKeys(jsonData.toString());
            Reporter.log("Data is entered in Textbox: " + jsonData);
            test.pass("Able to enter Data");

        } else {
            Reporter.log("textBox is not enabled.");
            test.fail("Not able to enter Data");

        }

        //Clicking on refresh button
        if (refreshButton.isEnabled()) {
            Reporter.log("Refresh Button is enabled.");
            refreshButton.click();
            Reporter.log("Refresh Button is clicked.");
            test.pass("Able to click on Refresh Button");

        } else {
            Reporter.log("Refresh Button is not enabled.");
            test.fail("Not able to click on Refresh Button");

        }

       //Doing assertion and validating the table
        if (dynamictable.isDisplayed()) {
            Reporter.log("Table is Displayed.");
            List<WebElement> tableRows = dynamictable.findElements(By.xpath("//*[text()='name']/parent::*/following-sibling::*"));

            for (int i = 0; i < jsonData.length(); i++) {
                JSONObject jsonObject = jsonData.getJSONObject(i);
                String[] rowName = tableRows.get(i).getText().split(" ");
                String name = rowName[1];
                String gender = rowName[0];
                String age = rowName[2];

                assert name.equals(jsonObject.getString("name")) : "Name does not match";
                assert age.equals(String.valueOf(jsonObject.getInt("age"))) : "Age does not match";
                assert gender.equals(jsonObject.getString("gender")) : "Gender does not match";
            }

            Reporter.log("All data correctly populated and verified.");
            test.pass("All data correctly populated and verified.");

        } else {
            Reporter.log("Table is not displayed");
            test.fail("Table is not displayed");

        }
    }

}
