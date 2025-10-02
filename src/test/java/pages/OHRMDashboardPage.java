package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class OHRMDashboardPage extends OHRMLoginPage {

    private By profileDD = By.xpath("//span[@class='oxd-userdropdown-tab']");

    public OHRMDashboardPage assertLogin() {
        assert Driver.getDriver().findElement(profileDD).isDisplayed();
        return this;
    }


}
