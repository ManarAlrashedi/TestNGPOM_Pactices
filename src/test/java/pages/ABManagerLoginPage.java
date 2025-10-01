package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class ABManagerLoginPage {

    public ABManagerLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    public WebElement managerLogin;

    @FindBy(xpath = "//button[.='Customer Login']")
    public WebElement customerLogin;
}
