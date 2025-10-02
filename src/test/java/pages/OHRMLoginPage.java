package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class OHRMLoginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By submit = By.xpath("//button[@type='submit']");
    private By errorForUsername = By.xpath("//div[@class='oxd-form-row' and contains(., 'Username')]//span");
    private By errorForPassword = By.xpath("//div[@class='oxd-form-row' and contains(., 'Password')]//span");
    private By invalidCredentials = By.xpath("//p[.='Invalid credentials']");

    public OHRMLoginPage enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.username));
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public OHRMLoginPage enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public OHRMDashboardPage clickLogin() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submit));
        submitButton.click();
        return new OHRMDashboardPage();
    }

    public OHRMLoginPage assertUsernameError() {
        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorForUsername)).getText();
        Assert.assertEquals(actualError, "Required");
        return this;
    }

    public OHRMLoginPage assertPasswordError() {
        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorForPassword)).getText();
        Assert.assertEquals(actualError, "Required");
        return this;
    }

    public OHRMLoginPage assertInvalidCredentials() {
        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentials)).getText();
        Assert.assertEquals(actualError, "Invalid credentials");
        return this;
    }
}