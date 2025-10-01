package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ABCustomerLoginPage {

    public ABCustomerLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//option[@value='2']")
    public WebElement customer;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;
}
