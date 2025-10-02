package smoke_test;

import org.testng.annotations.Test;
import pages.AddRecordPage;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutPageSmokeTest {

    @Test
    void addRecordFluentPOMTest() {

        AddRecordPage addRecordPage = new AddRecordPage();

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 5 records
        List<String> names = new ArrayList<>(Arrays.asList("Tom", "Mary", "Jane", "John", "Harry"));
        List<String> ages = new ArrayList<>(Arrays.asList("15", "30", "45", "10", "20"));
        List<String> countries = new ArrayList<>(Arrays.asList("USA", "Germany", "Australia", "Germany", "Canada"));
        for (int i = 0; i < 5; i++) {
            addRecordPage.enterName(names.get(i));
            addRecordPage.enterAge(ages.get(i));
            addRecordPage.selectCountry(countries.get(i));
            addRecordPage.clickOnAddRecord();
        }

//        Delete first record you created.
        addRecordPage
                .deleteRecordByName(names.getFirst())
                .assertTableNotContainsText(names.getFirst());

        Driver.closeDriver();
    }
}
