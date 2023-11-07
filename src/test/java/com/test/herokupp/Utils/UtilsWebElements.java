package com.test.herokupp.Utils;

import com.test.herokupp.Setup.DriverSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UtilsWebElements extends DriverSetup {

    @FindBy(xpath = "//h1[text()='Dynamic HTML TABLE Tag']")
    public WebElement pageName;

    @FindBy(xpath = "//*[text()='Table Data']")
    public WebElement tableDataDropDown;

    @FindBy(id = "jsondata")
    public WebElement textBox;

    @FindBy(id = "refreshtable")
    public WebElement refreshButton;

    @FindBy(id = "dynamictable")
    public WebElement dynamictable;






}
