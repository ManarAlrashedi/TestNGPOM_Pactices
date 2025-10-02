package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class DPSearchPageParallelTesting {
    private By searchBox = By.xpath("//textarea[@name='q']");
    private By searchResults = By.xpath("//div[@id='b_tween']");



    public DPSearchPageParallelTesting clickSearchBox() {
        Driver.getDriver().findElement(this.searchBox).click();
        return this;
    }
    public DPSearchPageParallelTesting enterSearchTerms(String searchTerm) {
        Driver.getDriver().findElement(this.searchBox).sendKeys(searchTerm);
        Driver.getDriver().findElement(this.searchBox).sendKeys(Keys.ENTER);
        return this;
    }

    public DPSearchPageParallelTesting assertSearchResult() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        assert Driver.getDriver().findElement(searchResults).isDisplayed();
        return this;
    }


}
