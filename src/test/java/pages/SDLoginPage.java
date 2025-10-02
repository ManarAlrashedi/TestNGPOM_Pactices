package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class SDLoginPage {


    public SDLoginPage(){



        PageFactory.initElements(Driver.getDriver(), this);
            }

            @FindBy(id = "user-name")
            private WebElement username;

            @FindBy(id = "password")
            private WebElement password;

            @FindBy(id = "login-button")
            private WebElement loginButton;


            public void login(String username, String password){
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                loginButton.click();
            }





}
