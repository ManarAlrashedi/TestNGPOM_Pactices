package smoke_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SDLoginPage;
import pages.SDProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePageSmokeTest {

    @Test
    void homePageTest() {
        SDLoginPage loginPage = new SDLoginPage();
        SDProductsPage productsPage = new SDProductsPage();

        String url = ConfigReader.getProperty("sd_url");
        String username = ConfigReader.getProperty("sd_username");
        String password = ConfigReader.getProperty("sd_password");

        Assert.assertNotNull(url, "sd_url is null. config.properties");
        Assert.assertNotNull(username, "sd_username is null.config.properties");
        Assert.assertNotNull(password, "sd_password is null.config.properties");

        Driver.getDriver().get(url);
        loginPage.login(username, password);
        productsPage.sortProducts(2);

        Assert.assertEquals(productsPage.getPriceList().getFirst(), 7.99);
        Assert.assertEquals(productsPage.getPriceList().getLast(), 49.99);

        Driver.closeDriver();
    }
}
