package smoke_test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class ProductPageSmokeTest extends TestBase {


    @Test
    void oHRMPositiveLoginTest() {//Happy Path
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertLogin();
        Driver.closeDriver();
    }

    }
