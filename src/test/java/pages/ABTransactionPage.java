package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ABTransactionPage {

    public ABTransactionPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement deposit;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amountD;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement depositDone;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement withdrawl;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amountW;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement withdrawlDone;

    @FindBy(xpath = "//button[@class='btn home']")
    public WebElement home;
}
