package com.test.herokupp.TestRunner;

import com.test.herokupp.Pages.HeroKuppHTMLPage;
import com.test.herokupp.Setup.DriverSetup;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeroKuppTestRunner extends DriverSetup {

    //Testcase of Insert json Data In Table
    @Test(priority = 1, description = "Insert json Data In Table")
    public void doInsertDataInTable() throws IOException, InterruptedException {
        HeroKuppHTMLPage HTMLPage = new HeroKuppHTMLPage(Driver);
        HTMLPage.TCInsertDataInTable(extent, Driver);
    }
}
