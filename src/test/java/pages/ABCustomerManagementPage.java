package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class ABCustomerManagementPage {

    public ABCustomerManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement openAccount;

    @FindBy(xpath = "//option[@value='2']")
    public WebElement customer;

    @FindBy(xpath = "//option[@value='Dollar']")
    public WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement process;

    @FindBy(xpath = "//button[@class='btn home']")
    public WebElement home;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customers;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/button[1]")
    public WebElement delete;



}
