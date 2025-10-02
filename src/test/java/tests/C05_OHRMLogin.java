package tests;

import org.testng.annotations.Test;
import pages.OHRMLoginPage;
import utilities.Driver;

public class C05_OHRMLogin {

    /*
        Task 1: Parallel Test Configuration
        Objective: Create a parallel test suite that runs login tests on multiple browsers simultaneously.
        Requirements:Create a TestNG XML file with parallel execution at the method level
        Set thread count to 3
        Include at least 2 test classes: PositiveLoginTest and NegativeLoginTest
        Configure timeout for each test method to 30 seconds
        Expected Output: All tests should run in parallel, reducing total execution time.
     */

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

    @Test
    void oHRMNegativeLoginTest1() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                //.enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertUsernameError();
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest2() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                .enterUsername("Admin")
                //.enterPassword("admin123")
                .clickLogin()
                .assertPasswordError();
        Driver.closeDriver();
    }

    @Test
    void oHRMNegativeLoginTest3() {
        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
//                .enterUsername("Admin")
//                .enterPassword("admin123")
                .clickLogin()
                .assertUsernameError()
                .assertPasswordError();
        Driver.closeDriver();
    }


}
