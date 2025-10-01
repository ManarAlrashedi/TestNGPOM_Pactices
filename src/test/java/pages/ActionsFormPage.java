package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ActionsFormPage {

    private By name = By.id("name");
    private By age = By.id("age");
    private By departments = By.id("options");
    private By coding = By.xpath("//input[@value='coding']");
    private By design = By.xpath("//input[@value='design']");
    private By management = By.xpath("//input[@value='management']");
    private By male = By.xpath("//input[@value='male']");
    private By female = By.xpath("//input[@value='female']");
    private By other = By.xpath("//input[@value='other']");
    private By generate = By.xpath("//*[.='Generate Passcode']");
    private By submit = By.id("submitButton");
    private WebDriver driver;

    public ActionsFormPage enterName(String name) {
        Driver.getDriver().findElement(this.name).sendKeys(name);
        return this;
    }

    public ActionsFormPage enterAge(String age) {
        Driver.getDriver().findElement(this.age).sendKeys(age);
        return this;
    }

    public ActionsFormPage selectDepartment(String department) {
        new Select(Driver.getDriver().findElement(departments)).selectByVisibleText(department);
        return this;
    }

    public ActionsFormPage clickCoding() {
        Driver.getDriver().findElement(coding).click();
        return this;
    }

    public ActionsFormPage clickDesign() {
        Driver.getDriver().findElement(design).click();
        return this;
    }

    public ActionsFormPage clickManagement() {
        Driver.getDriver().findElement(management).click();
        return this;
    }

    public ActionsFormPage clickMale() {
        Driver.getDriver().findElement(male).click();
        return this;
    }

    public ActionsFormPage clickFemale() {
        Driver.getDriver().findElement(female).click();
        return this;
    }

    public ActionsFormPage clickOther() {
        Driver.getDriver().findElement(other).click();
        return this;
    }

    public ActionsFormPage clickGenerate() {
        driver = Driver.getDriver();
        driver.findElement(generate).click();
        return this;
    }

    public ActionsFormPage handleJSAlertPasscode() {
        String code = driver.switchTo().alert().getText().replaceAll("\\D", "");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(code);
        driver.switchTo().alert().accept();
        return this;
    }

    public ActionsFormPage clickSubmit() {
        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().findElement(submit).click();
        return this;
    }
}