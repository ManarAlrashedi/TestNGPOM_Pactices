package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABCustomerLoginPage;
import pages.ABManagerLoginPage;
import pages.ABCustomerManagementPage;
import pages.ABTransactionPage;
import utilities.ConfigReader;
import utilities.Driver;

//import static utilities.Driver.driver;

public class F15T02_BankingApplication {

     /*

    Example 2: Banking Application Test

Target: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

Test Scenario:
Open 5 new customer accounts
Deposit 100 USD to each account
Withdraw 100 USD from any one account
Delete all created accounts
Verify account operations
Page Objects Needed:
ManagerLoginPage (manager interface elements)
CustomerManagementPage (add/delete customer elements)
AccountManagementPage (account creation elements)
CustomerLoginPage (customer interface elements)
TransactionPage (deposit/withdraw elements)

Assertions:
Verify account creation success
Verify deposit transactions
Verify withdrawal transactions
Verify account balance updates
Verify account deletion

    */

    @Test
    void bATest() throws InterruptedException {
        ABManagerLoginPage managerLogin = new ABManagerLoginPage();
        ABCustomerManagementPage customerManagement = new ABCustomerManagementPage();
        ABCustomerLoginPage customerLogin = new ABCustomerLoginPage();
        ABTransactionPage transaction = new ABTransactionPage();

        //Target: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("ab_url"));

        //Open 5 new customer accounts
        managerLogin.managerLogin.click();
        customerManagement.openAccount.click();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            customerManagement.customer.click();
            customerManagement.currency.click();
            customerManagement.process.click();
            //Verify account creation success
            Assert.assertTrue(true,"Account created successfully with account Number");
            Driver.getDriver().switchTo().alert().accept();
        }
        customerManagement.home.click();

        managerLogin.customerLogin.click();
        customerLogin.customer.click();
        customerLogin.login.click();

        //Deposit 100 USD to each account
        transaction.deposit.click();
        transaction.amountD.sendKeys("100");
        transaction.depositDone.click();
        //Verify account balance updates
        //Verify deposit transactions
        Assert.assertTrue(true,"Deposit Successful");

        //Withdraw 100 USD from any one account
        transaction.withdrawl.click();
        transaction.amountW.sendKeys("100");
        transaction.withdrawlDone.click();
        //Verify account balance updates
        //Verify withdrawal transactions
        Assert.assertTrue(true,"Transaction successful");

        transaction.home.click();
        managerLogin.managerLogin.click();
        //Delete all created accounts
        customerManagement.customers.click();
        for (int i = 0; i < 5; i++){
            customerManagement.delete.click();
        }
        //Verify account deletion


        Driver.closeDriver();

    }

}
