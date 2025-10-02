package tests;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CLRegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;
import utilities.MyTestListener;

import java.time.LocalTime;


@Listeners(MyTestListener.class)

public class F17T2_ScreenshotCaptureListenerforFailedTests {

  /*  Objective: Implement a custom TestNG listener that automatically captures screenshots when tests
    fail.
            Requirements:
    Create a custom listener class implementing ITestListener interface
    Override the onTestFailure method to capture screenshots
                    Save screenshots in a "screenshots" folder with meaningful names (testName_timestamp.png)
    Include browser setup in the listener to access WebDriver instance
    Apply the listener to a test class that contains at least one intentionally failing test
            Verify screenshots are captured and saved correctly when tests fail

            Expected Output: When any test fails, a screenshot should be automatically captured and saved with
    a descriptive filename including test name and timestamp.
*/


    @BeforeMethod
    void beforMethod() {

        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test is starting: " + LocalTime.now());
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
    }
    @AfterMethod
    void afterMethod(ITestResult result) {
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
        Driver.closeDriver();
    }

    CLRegistrationPage registrationPage;
    @Test
    void happyPath() {
        registrationPage = new CLRegistrationPage();
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertAddContactButton();
    }

    @Test
    void emptyFirstnameTest() {
        registrationPage = new CLRegistrationPage();
        registrationPage
                .enterLastname(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("`firstName` is required.");
        assert false;
    }

}
