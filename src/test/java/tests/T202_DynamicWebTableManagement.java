package tests;

import org.testng.annotations.Test;
import pages.FluentWebTablePage;
import utilities.DataProviderUtilities;
import utilities.Driver;
public class T202_DynamicWebTableManagement {

    /*

    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider

    Requirements:
    Create a FluentWebTablePage class
    Implement fluent methods for adding table records
    Use TestNG DataProvider for multiple record sets
    Chain table operations (add, verify, delete if needed)
    Validate table content after each addition

    */



    @Test(dataProvider = "tableData",dataProviderClass = DataProviderUtilities.class)
    void DynamicWebTableManagement(String name, String age, String country) {

        FluentWebTablePage  webTablePage = new FluentWebTablePage();

        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");


//        Add records to the table using DataProvider

        webTablePage
                .enterName(name)
                .enterAge(age)
                .selectCountry(country)
                .clickOnAddRecord()
                .assertTableContainsText(name)
                .assertTableContainsText(age)
                .assertTableContainsText(country);
/*

        addRecordPage
                .deleteRecordByName(names.getFirst())
                .assertTableNotContainsText(names.getFirst());
*/


        Driver.closeDriver();
    }
}