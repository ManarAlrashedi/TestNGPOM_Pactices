package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CLRegistrationPage {

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By submit = By.id("submit");
    private By errorMessage = By.id("error");

    public CLRegistrationPage enterFirstname(String firstName) {
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public CLRegistrationPage enterLastname(String lastName) {
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public CLRegistrationPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public CLRegistrationPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public CLRegistrationPage assertErrorMessage(String message) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        assertTrue(Driver.getDriver().findElement(this.errorMessage).getText().contains(message));
        return this;
    }

    public CLContactListPage clickSubmit() {
        Driver.getDriver().findElement(submit).click();
        return new CLContactListPage();
    }


}
