package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsPage {

    private By source = By.xpath("//div[@id='drag1']");
    private By target = By.xpath("//div[@id='drop1']");
    private By contextClick = By.id("showSuccessButton");
    private By doubleClick = By.id("doubleClickButton");
    private By hover = By.id("hoverButton");

    public ActionsPage actions(){
        Set<String> wHandles = Driver.getDriver().getWindowHandles();
        List<String> windowHandles = new ArrayList<>(wHandles);
        if (windowHandles.size() > 1) {
            Driver.getDriver().switchTo().window(windowHandles.get(1));
        }

        WebElement src = Driver.getDriver().findElement(this.source);
        WebElement tgt = Driver.getDriver().findElement(this.target);

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(src)
                .moveToElement(tgt)
                .pause(Duration.ofSeconds(1))
                .release()
                .perform();

        actions.contextClick(Driver.getDriver().findElement(this.contextClick))
                .doubleClick(Driver.getDriver().findElement(this.doubleClick))
                .moveToElement(Driver.getDriver().findElement(this.hover))
                .perform();

        return this;
    }

    public ActionsPage assertDragDrop() {
        WebElement tgt = Driver.getDriver().findElement(this.target);
        Assert.assertTrue(tgt.findElements(By.id("drag1")).size() > 0, "Item was not dropped correctly!");
        return this;
    }

    public ActionsPage assertClick() {
        WebElement btn = Driver.getDriver().findElement(this.contextClick);
        Assert.assertTrue(btn.isDisplayed() && btn.isEnabled(), "Button was not right-clicked!");
        return this;
    }

    public ActionsPage assertDoubleClick() {
        WebElement btn = Driver.getDriver().findElement(this.doubleClick);
        Assert.assertTrue(btn.isDisplayed() && btn.isEnabled(), "Button was not double-clicked!");
        return this;
    }

    public ActionsPage assertHover() {
        WebElement btn = Driver.getDriver().findElement(this.hover);
        Assert.assertTrue(btn.isDisplayed(), "Hover action did not trigger!");
        return this;
    }
}