package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class SDProductsPage {


    public SDProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sort;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> priceList;

    public void sortProducts(String visibleText) {
        new Select(sort).selectByVisibleText(visibleText);
    }

    public void sortProducts(int index) {
        new Select(sort).selectByIndex(index);
    }

    public List<Double> getPriceList() {
        List<Double> list = new ArrayList<>();
        for (WebElement element : priceList) {
            list.add(Double.parseDouble(element.getText().replaceAll("[^0-9.]", "")));
        }
        return list;
    }}


