package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;



public class FluentWebTablePage {


    private WebDriver driver;
    private By nameInput = By.xpath("//*[@id=\"nameInput\"]");
    private By ageInput = By.xpath("//*[@id=\"ageInput\"]");
    private By countrySelect = By.xpath("//*[@id=\"countrySelect\"]");
    private By addRecordButton = By.xpath("//button[@onclick='addRecord()']");
    private String deleteButtonByNameXPath = "//tr[contains(.,'%s')]//button[@class='delete-button']";
    private By tableBody = By.id("tableBody");



    public FluentWebTablePage enterName(String name) {
        Driver.getDriver().findElement(nameInput).sendKeys(name);
        return this;
    }

    public FluentWebTablePage enterAge(String age) {
        Driver.getDriver().findElement(ageInput).sendKeys(age);
        return this;
    }

    public FluentWebTablePage selectCountry(int index) {
        new Select(Driver.getDriver().findElement(countrySelect)).selectByIndex(index);
        return this;
    }

    public FluentWebTablePage selectCountry(String visibleText) {
        new Select(Driver.getDriver().findElement(countrySelect)).selectByVisibleText(visibleText);
        return this;
    }

    public FluentWebTablePage clickOnAddRecord() {
        Driver.getDriver().findElement(addRecordButton).click();
        return this;
    }

    public FluentWebTablePage deleteRecordByName(String recordName) {
        Driver.getDriver().findElement(By.xpath(String.format(deleteButtonByNameXPath, recordName))).click();
        return this;
    }

    public FluentWebTablePage assertTableContainsText(String text) {
        assertTrue(Driver.getDriver().findElement(tableBody).getText().contains(text));
        return this;
    }

    public FluentWebTablePage assertTableNotContainsText(String text) {
        assertFalse(Driver.getDriver().findElement(tableBody).getText().contains(text));
        return this;


    }

}