package tests;

import org.testng.annotations.Test;
import pages.ActionsFormPage;
import pages.ActionsPage;
import utilities.Driver;

public class C201_ActionsForm {
    /*
        Go to https://claruswaysda.github.io/ActionsForm.html
        Fill form and submit
        Do all actions and assert
    */

    @Test
    void C03_ActionsFormTest() {
        ActionsFormPage formPage = new ActionsFormPage();
        ActionsPage actionsPage = new ActionsPage();

        //        Go to https://claruswaysda.github.io/ActionsForm.html
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

        //        Fill form and submit
        formPage
                .enterName("John")
                .enterAge("30")
                .selectDepartment("IT Department")
                .clickCoding()
                .clickMale()
                .clickGenerate()
                .handleJSAlertPasscode()
                .clickSubmit();

        //        Do all actions and assert
        actionsPage
                .actions()
                .assertDragDrop()
                .assertClick()
                .assertDoubleClick()
                .assertHover();

        Driver.closeDriver();
    }
}
