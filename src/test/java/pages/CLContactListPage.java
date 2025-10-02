package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class CLContactListPage extends CLRegistrationPage {

    public CLContactListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "add-contact")
    public WebElement addContact;

    @FindBy(xpath = "//table/tr")
    public List<WebElement> contactRows;

    public CLContactListPage assertAddContactButton() {
        Assert.assertTrue(addContact.isDisplayed());
        return this;
    }


}
